package com.frontline.webapi.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.frontline.webapi.GlobalConfig;
import com.frontline.webapi.output.License;
import com.frontline.webapi.output.LicenseRole;
import com.frontline.webapi.output.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LicenseService {

	@Autowired
	private GlobalConfig globalConfig;

	private RestTemplate restTemplate;

	public LicenseService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public List<License> getLicense(String accessToken) {
		String apiUrl = globalConfig.getApiUrl();
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(header);
		// Give The URL
		String url = apiUrl + "license/getAll";

		ResponseEntity<License[]> licenseList = restTemplate.exchange(url, HttpMethod.GET, entity, License[].class);
		License[] licenseListArray = licenseList.getBody();

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			@SuppressWarnings("unused")
			String json = objectMapper.writeValueAsString(licenseListArray);

			List<String> purchaseOrders = new ArrayList<>();
			List<Integer> amounts = new ArrayList<>();
			List<String> licenseTiers = new ArrayList<>();
			List<Date> startDates = new ArrayList<>();
			List<Date> stopDates = new ArrayList<>();

			for (License license : licenseListArray) {

				for (Order order : license.getOrders()) {
					for (LicenseRole role : order.getRoles()) {
						purchaseOrders.add(order.getPurchaseOrder());
						amounts.add(role.getAmount());
						licenseTiers.add(role.getLicenseTier());
						startDates.add(role.getStartDate());
						stopDates.add(role.getStopDate());

					}

				}

			}

			// convert to Excel Sheet
			writeToExcel(purchaseOrders, amounts, licenseTiers, startDates, stopDates);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return Arrays.asList(licenseListArray);

	}

	private static void writeToExcel(List<String> purchaseOrders, List<Integer> amounts, List<String> licenseTiers,
			List<Date> startDates, List<Date> stopDates) {

		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Purchase order");
		headerRow.createCell(1).setCellValue("Quantity");
		headerRow.createCell(2).setCellValue("Solution");
		headerRow.createCell(3).setCellValue("Valid From");
		headerRow.createCell(4).setCellValue("Valid Until");
		headerRow.createCell(5).setCellValue("Status");

		// Create cell style
		CreationHelper createHelper = workbook.getCreationHelper();
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("MMMM dd ,yyyy hh:mm:ss AM/PM"));

		// Apply Filter to header
		sheet.setAutoFilter(CellRangeAddress.valueOf("A1:F1"));
		// write data rows
		int rowCount = 1;

		LocalDate currentDate = LocalDate.now();

		for (int i = 0; i < purchaseOrders.size(); i++) {

			System.out.println("purchaseOrders");
			System.out.println(purchaseOrders.get(i));
			Row row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(purchaseOrders.get(i));
			row.createCell(1).setCellValue(amounts.get(i));
			row.createCell(2).setCellValue(licenseTiers.get(i));

			System.out.println("startDates");
			System.out.println("date =" + startDates.get(i));

			Cell startDateCell = row.createCell(3);
			startDateCell.setCellValue(startDates.get(i));
			startDateCell.setCellStyle(dateCellStyle);

			Cell stopDateCell = row.createCell(4);
			stopDateCell.setCellValue(stopDates.get(i));
			stopDateCell.setCellStyle(dateCellStyle);

			LocalDate expirationDate = stopDates.get(i).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			boolean isExpired = expirationDate.isBefore(currentDate);

			if (isExpired) {
				row.createCell(5).setCellValue("InActive");
			} else {
				row.createCell(5).setCellValue("Active");
			}

		}

		for (int i = 0; i < 6; i++) {

			sheet.autoSizeColumn(i);
		}

		// save the workbook to a file

		try (FileOutputStream outputStream = new FileOutputStream("data.xlsx")) {
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
