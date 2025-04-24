package service;

import java.util.ArrayList;
import java.util.List;


import dao.OrderDAO;
import dao.ProductDAO;
import model.dto.OrderDTO;
import model.dto.ProductDTO;
import model.entity.Order;
import model.entity.Product;

public class ProductService {
	private ProductDAO productDAO =new ProductDAO();
	
	
	public List<ProductDTO> findAll(){
		List<Product> products =productDAO.findAll(); //取得所有資料
		//將List<Product>轉List<ProductDTO>
		List<ProductDTO> productDTOs = new ArrayList<>();
		//一筆一筆轉
		for(Product product : products ){
				productDTOs.add(new ProductDTO(product.getItem(), product.getPrice()));
			
		}

		return productDTOs;
	}
		public ProductDTO getProductDTO(String item) {
			Product product = productDAO.getProduct(item);
			return new ProductDTO(product.getItem(), product.getPrice());
		}
		
		//根據message取得價格(模糊比對)
		public Integer getPrice(String message) {
			return productDAO.findAll()
					.stream()
					.filter(p -> message.contains(p.getItem()))
					.findFirst()
					.get()
					.getPrice();
		}
}
