package C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB_Connection.Conn;
import M.ProductModel;

public class ProductController {

	ProductModel proMo = ProductModel.getInstance();

	private static final ProductController insProductController = new ProductController();

	private ProductController() {
	}

	public static ProductController getInstance() {
		return insProductController;
	}

	public String saveNewProduct() {
		String msg = "Fail";
		try {
			Connection conn = Conn.getMyConnection();
			String sql = "insert into product_registration values (? , ? , ? , ? , ?)";
			try (PreparedStatement prSt = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				prSt.setString(1, proMo.getProductCode());
				prSt.setString(2, proMo.getProductName());
				prSt.setString(3, proMo.getDescription());
				prSt.setInt(4, proMo.getStatus());
				prSt.setString(5, proMo.getDateTime());
				prSt.executeUpdate();
				conn.commit();
				prSt.close();
				msg = "Pass";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public List<Object> loadAllProducts() {
		List<Object> productList = new ArrayList<>();
		Connection conn = Conn.getMyConnection();
		String sql = "select * from product_registration where status = '1'";
		try (Statement stMt = conn.createStatement()) {
			conn.setAutoCommit(false);
			ResultSet rset = stMt.executeQuery(sql);
			while (rset.next()) {
				String productDetails = rset.getString(1).concat("_").concat(rset.getString(2)).concat("_")
						.concat(rset.getString(3)).concat("_").concat(rset.getString(4)).concat("_")
						.concat(rset.getString(5)).concat("_");
				productList.add(productDetails);
			}
			conn.commit();
			stMt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public String getProductDetails() {
		String productDetails = "";
		Connection conn = Conn.getMyConnection();
		String sql = "select * from product_registration where product_code = '" + proMo.getProductCode()
				+ "' && status = '1'";
		try (Statement stMt = conn.createStatement()) {
			conn.setAutoCommit(false);
			ResultSet rset = stMt.executeQuery(sql);
			if (rset.next()) {
				productDetails = rset.getString(1).concat("_").concat(rset.getString(2)).concat("_")
						.concat(rset.getString(3)).concat("_").concat(rset.getString(4)).concat("_")
						.concat(rset.getString(5));
			}
			conn.commit();
			stMt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetails;
	}

	public void updateSelectedProduct(String selectedProductCode) {
		try {
			String sql = "update product_registration set product_name = ? , description = ? ,status = ? , date_time = ? "
					+ "where product_code = '" + selectedProductCode + "'";
			Connection conn = Conn.getMyConnection();
			try (PreparedStatement prSt = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				prSt.setString(1, proMo.getProductName());
				prSt.setString(2, proMo.getDescription());
				prSt.setInt(3, proMo.getStatus());
				prSt.setString(4, proMo.getDateTime());
				prSt.executeUpdate();
				conn.commit();
				prSt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSelectedProduct(String selectedProductCode) {
		try {
			String sql = "delete from product_registration where product_code = '" + selectedProductCode + "'";
			Connection conn = Conn.getMyConnection();
			try (PreparedStatement prSt = conn.prepareStatement(sql)) {
				conn.setAutoCommit(false);
				prSt.executeUpdate();
				conn.commit();
				prSt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
