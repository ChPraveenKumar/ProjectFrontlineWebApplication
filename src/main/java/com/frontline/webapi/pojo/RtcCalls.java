package com.frontline.webapi.pojo;

import java.util.List;

public class RtcCalls {
	
	private List<Content> content;
	private boolean empty;
	private boolean first;
	private boolean last;
	private long number;
	private long numberOfElements;
	private Pageable pageable;
	private long size;
	private Sort sort;
	private long totalElements;
	private long totalPages;
	
	
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public long getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(long numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public Pageable getPageable() {
		return pageable;
	}
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	@Override
	public String toString() {
		return "RtcCalls [content=" + content + ", empty=" + empty + ", first=" + first + ", last=" + last + ", number="
				+ number + ", numberOfElements=" + numberOfElements + ", pageable=" + pageable + ", size=" + size
				+ ", sort=" + sort + ", totalElements=" + totalElements + ", totalPages=" + totalPages + "]";
	}
	
}
