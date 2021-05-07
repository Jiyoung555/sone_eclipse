package com.mycompany.sone.dto;

public class PageDTO {
    //**필수 필드값
    private int pageNum; //현재 페이지
    private int rowsPerPage; //페이지 당 보여주는 게시글 수
    private int pageCount; //노출 페이지
    private int totalRows; //전체 게시글 수 (전체 데이터)

    //--------------------------

    //**계산식 필요한 필드
    private int prev; //이전페이지
    private int next; //다음페이지
    private int startPage; //현재 페이지 기준으로 첫 번쨰 페이지
    private int endPage; //현재 페이지 기준으로 마지막 페이지
    private int firstPage; //무조건 첫 번째 페이지
    private int lastPage; //무조건 마지막 페이지
    private int startRowIndex; //시작글 index 번호

    //--------------------------

    //생성자
    public PageDTO(int pageNum, int rowsPerPage, int pageCount, int totalRows){
        //필수값 만들기
        this.pageNum = pageNum;
        this.rowsPerPage = rowsPerPage;
        this.pageCount = pageCount;
        this.totalRows = totalRows;

        //계산식 만들기
        this.prev = pageNum - 1; //이전 페이지
        this.next = pageNum + 1; //다음 페이지
        this.startPage = ( (pageNum-1)/pageCount ) * pageCount + 1; //첫 번쨰 페이지(내가 있는 페이지 기준)
        this.endPage =( (pageNum-1)/pageCount + 1) * pageCount; //마지막 페이지(내가 있는 페이지 기준)
        this.firstPage = 1; //무조건 첫 번쨰 페이지
   
        if ( totalRows % rowsPerPage == 0 ) { //무조건 마지막 페이지
            this.lastPage = totalRows/rowsPerPage;
        } else {
            this.lastPage = totalRows/rowsPerPage + 1;
        }
        
        if(this.endPage > this.lastPage) {
            this.endPage = this.lastPage;
        }
        
        this.startRowIndex = (pageNum-1)*rowsPerPage; 
        //페이지에서 첫번째 index값
        
    }//end 생성자

    
    public PageDTO() {} //디폴트 생성자
    
    //게터, 세터
    
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStartRowIndex() {
		return startRowIndex;
	}

	public void setStartRowIndex(int startRowIndex) {
		this.startRowIndex = startRowIndex;
	}
    
}
