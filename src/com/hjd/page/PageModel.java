package com.hjd.page;

import java.util.List;

public class PageModel {
    private List<?> list;  		
    private int totalRecords; 
    private int pageSize; 	
    private int pageNo;  	
    private int totalPages;  	
    
    public int getTotalPages() {  
    	totalPages=(totalRecords + pageSize - 1) / pageSize;
        return totalPages;  
    }  
    public int getTopPageNo() { 
        return 1;  
    }  
    public int getPreviousPageNo() { 
        if (pageNo <= 1) {  
            return 1;  
        }  
        return pageNo - 1;  
    }  
    public int getNextPageNo() { 
        if (pageNo >= getBottomPageNo()) {  
            return getBottomPageNo();  
        }  
        return pageNo + 1;    
    }  
    public int getBottomPageNo() {
        return getTotalPages();  
    }  
    public List<?> getList() { 
        return list;  
    }  
    public void setList(List<?> list) {  
        this.list = list;  
    }  
    public int getTotalRecords() { 
        return totalRecords;  
    }  
    public void setTotalRecords(int totalRecords) {  
        this.totalRecords = totalRecords;  
    }  
    public int getPageSize() {  
        return pageSize;  
    }  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
    public int getPageNo() {  
        return pageNo;  
    }  
    public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
}
