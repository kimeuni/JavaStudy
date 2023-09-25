package t10_sale;

public class saleVO {
	private int idx;
	private String pName;
	private int ea;
	private String pDate;	//날짜타입도 있지만, String타입으로 많이 한다고함. //날짜 타입을 하는 경우는 연산?할 때 사용하는데 그것도 String으로 비교하는 방법이 있다고는 함..
	
	private int salePrice;	// 실제 판매 가격 계산용 (갯수 * 상품 가격)
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	@Override
	public String toString() {
		return "saleVO [idx=" + idx + ", pName=" + pName + ", ea=" + ea + ", pDate=" + pDate + ", salePrice="
				+ salePrice + "]";
	}
}
