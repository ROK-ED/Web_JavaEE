package com.yedam.shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp.DAO;

public class ShopDAO extends DAO {
	// 전체 조회
	public List<ShopItem> getItemList() {
		List<ShopItem> list = new ArrayList<>();
		String sql = "select * from shop_item order by 1 desc";
		// 1. db연결.
		connect();
		// 2. 쿼리 결과
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ShopItem shopItem = new ShopItem(rs.getString("item_code"), rs.getString("item_name"), rs.getString("item_desc"), rs.getInt("origin_price"), rs.getInt("sale_price"), rs.getDouble("like_it"), rs.getString("image"));
				list.add(shopItem);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;

	}
	// 한건 입력

	public void insertShopItem(ShopItem si) {
		String sql = "insert into shop_item (item_code, item_name, item_desc, origin_price, sale_price, like_it, image) values (?,?,?,?,?,?,?)";

		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, si.getItemCode());
			psmt.setString(2, si.getItemName());
			psmt.setString(3, si.getItemDesc());
			psmt.setInt(4, si.getOriginPrice());
			psmt.setInt(5, si.getSalePrice());
			psmt.setDouble(6, si.getLikeIt());
			psmt.setString(7, si.getImage());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
}
