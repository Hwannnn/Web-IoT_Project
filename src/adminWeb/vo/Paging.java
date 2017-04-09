package adminWeb.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Paging {
    private int pageSize; // �Խ� �� ��
    private int firstPageNo; // ù ��° ������ ��ȣ
    private int prevPageNo; // ���� ������ ��ȣ
    private int startPageNo; // ���� ������ (����¡ �׺� ����)
    private int pageNo; // ������ ��ȣ
    private int endPageNo; // �� ������ (����¡ �׺� ����)
    private int nextPageNo; // ���� ������ ��ȣ
    private int finalPageNo; // ������ ������ ��ȣ
    private int totalCount; // �Խ� �� ��ü ��
    private int n1;
    private String search;
    
    public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	private String con;
    
	/**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the firstPageNo
     */
    public int getFirstPageNo() {
        return firstPageNo;
    }

    /**
     * @param firstPageNo the firstPageNo to set
     */
    public void setFirstPageNo(int firstPageNo) {
        this.firstPageNo = firstPageNo;
    }

    /**
     * @return the prevPageNo
     */
    public int getPrevPageNo() {
        return prevPageNo;
    }

    /**
     * @param prevPageNo the prevPageNo to set
     */
    public void setPrevPageNo(int prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    /**
     * @return the startPageNo
     */
    public int getStartPageNo() {
        return startPageNo;
    }

    /**
     * @param startPageNo the startPageNo to set
     */
    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the endPageNo
     */
    public int getEndPageNo() {
        return endPageNo;
    }

    /**
     * @param endPageNo the endPageNo to set
     */
    public void setEndPageNo(int endPageNo) {
        this.endPageNo = endPageNo;
    }

    /**
     * @return the nextPageNo
     */
    public int getNextPageNo() {
        return nextPageNo;
    }

    /**
     * @param nextPageNo the nextPageNo to set
     */
    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    /**
     * @return the finalPageNo
     */
    public int getFinalPageNo() {
        return finalPageNo;
    }

    /**
     * @param finalPageNo the finalPageNo to set
     */
    public void setFinalPageNo(int finalPageNo) {
        this.finalPageNo = finalPageNo;
    }

    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.makePaging();
    }
    public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}
    /**
     * ����¡ ����
     */
    private void makePaging() {
        if (this.pageNo == 0) this.setPageNo(1); // �⺻ �� ����
        if (this.pageSize == 0) this.setPageSize(10); // �⺻ �� ����
        if (this.totalCount == 0) {this.setN1(1);return;} // �Խ� �� ��ü ���� ���� ���

        int finalPage = (totalCount + (pageSize - 1)) / pageSize; // ������ ������
        if (this.pageNo > finalPage) this.setPageNo(finalPage); // �⺻ �� ����

        if (this.pageNo < 0 || this.pageNo > finalPage) this.pageNo = 1; // ���� ������ ��ȿ�� üũ

        boolean isNowFirst = pageNo == 1 ? true : false; // ���� ������ (��ü)
        boolean isNowFinal = pageNo == finalPage ? true : false; // ������ ������ (��ü)

        int startPage = ((pageNo - 1) / 10) * 10 + 1; // ���� ������ (����¡ �׺� ����)
        int endPage = startPage + 10 - 1; // �� ������ (����¡ �׺� ����)
        
        if (endPage > finalPage) { // [������ ������ (����¡ �׺� ����) > ������ ������] ���� ū ���
            endPage = finalPage;
        }

        this.setFirstPageNo(1); // ù ��° ������ ��ȣ

        if (isNowFirst) {
            this.setPrevPageNo(1); // ���� ������ ��ȣ
        } else {
            this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); // ���� ������ ��ȣ
        }

        this.setStartPageNo(startPage); // ���� ������ (����¡ �׺� ����)
        this.setEndPageNo(endPage); // �� ������ (����¡ �׺� ����)

        if (isNowFinal) {
            this.setNextPageNo(finalPage); // ���� ������ ��ȣ
        } else {
            this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1))); // ���� ������ ��ȣ
        }

        this.setFinalPageNo(finalPage); // ������ ������ ��ȣ
        
        if (this.getPageNo() == 1) {
        	this.setN1(1);
        } else {
        	this.setN1((this.getPageNo()-1)*10 + 1);
        }
    }



	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}