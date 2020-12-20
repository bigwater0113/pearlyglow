package kr.co.pearlyglow.vo;

public class StockSearchVo {
	private String searchCategory;
	private String searchGender;
	private String searchColor;
	private String searchMaterial;
	private String searchStock;
	private String searchText;
	
	/*
	public StockSearchVo(String searchCategory, String searchGender, String searchColor, String searchMaterial,
			String searchStock, String searchText) {
		super();
		this.searchCategory = searchCategory;
		this.searchGender = searchGender;
		this.searchColor = searchColor;
		this.searchMaterial = searchMaterial;
		this.searchStock = searchStock;
		this.searchText = searchText;
	}
	*/
	
	public StockSearchVo() {}
	public String getSearchCategory() {
		return searchCategory;
	}
	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}
	public String getSearchGender() {
		return searchGender;
	}
	public void setSearchGender(String searchGender) {
		this.searchGender = searchGender;
	}
	public String getSearchColor() {
		return searchColor;
	}
	public void setSearchColor(String searchColor) {
		this.searchColor = searchColor;
	}
	public String getSearchMaterial() {
		return searchMaterial;
	}
	public void setSearchMaterial(String searchMaterial) {
		this.searchMaterial = searchMaterial;
	}
	public String getSearchStock() {
		return searchStock;
	}
	public void setSearchStock(String searchStock) {
		this.searchStock = searchStock;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
}
