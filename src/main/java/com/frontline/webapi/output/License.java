package com.frontline.webapi.output;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class License {

	@JsonProperty("id")
	private String id;

	@JsonProperty("domainTag")
	private String domainTag;

	@JsonProperty("name")
	private String name;

	@JsonProperty("metricsEnabled")
	private boolean metricsEnabled;

	@JsonProperty("orders")
	private List<Order> orders;

	@JsonProperty("privateKeyAlias")
	private String privateKeyAlias;

	@JsonProperty("usage")
	private JsonNode usage;

	public String getDomainTag() {
		return domainTag;
	}

	public void setDomainTag(String domainTag) {
		this.domainTag = domainTag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMetricsEnabled() {
		return metricsEnabled;
	}

	public void setMetricsEnabled(boolean metricsEnabled) {
		this.metricsEnabled = metricsEnabled;
	}

	public String getPrivateKeyAlias() {
		return privateKeyAlias;
	}

	public void setPrivateKeyAlias(String privateKeyAlias) {
		this.privateKeyAlias = privateKeyAlias;
	}

	public JsonNode getUsage() {
		return usage;
	}

	public void setUsage(JsonNode usage) {
		this.usage = usage;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "License [id=" + id + ", domainTag=" + domainTag + ", name=" + name + ", metricsEnabled="
				+ metricsEnabled + ", privateKeyAlias=" + privateKeyAlias + ", usage=" + usage + ", orders=" + orders
				+ "]";
	}

}
