package M;

public class ProductModel {

	private String productCode;
	private String productName;
	private String description;
	private int status;
	private String dateTime;
		
	
	private static final ProductModel insProductModel = new ProductModel();

    private ProductModel() {
    }

    public static ProductModel getInstance() {
        return insProductModel;
    }

	public synchronized String getProductCode() {
		return productCode;
	}

	public synchronized void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public synchronized String getProductName() {
		return productName;
	}

	public synchronized void setProductName(String productName) {
		this.productName = productName;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}

	public synchronized int getStatus() {
		return status;
	}

	public synchronized void setStatus(int status) {
		this.status = status;
	}

	public synchronized String getDateTime() {
		return dateTime;
	}

	public synchronized void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public static synchronized ProductModel getInsproductmodel() {
		return insProductModel;
	}
    
}
