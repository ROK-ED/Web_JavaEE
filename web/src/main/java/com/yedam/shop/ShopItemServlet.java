package com.yedam.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ShopItemServlet")
public class ShopItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShopItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8"); //요청정보 한글
		response.setCharacterEncoding("utf-8"); //응답정보 한글
		response.setContentType("text/json;charset=utf-8");
		ShopDAO dao = new ShopDAO();
		List<ShopItem> list = dao.getItemList();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.getWriter().print(gson.toJson(list).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //요청정보 한글
		response.setCharacterEncoding("utf-8"); //응답정보 한글
		response.setContentType("text/json;charset=utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setContentType("text/xml;charset=utf-8");
		
		String item_code = request.getParameter("item_code");
		System.out.println(item_code);//요청정보에서 getParameter 못받아옴
		
		// 1.request 2.저장위치 3.maxSize 4.UTF-8 5.리네임정책
		ServletContext context = getServletContext();
		String savePath = context.getRealPath("upload");
		int maxSize = 1021 * 1024 * 30;
		String encodeing = "UTF-8";
		MultipartRequest mRequest = new MultipartRequest(request, savePath, maxSize, encodeing, new DefaultFileRenamePolicy());

		String itemCode = mRequest.getParameter("item_code");
		String itemName = mRequest.getParameter("item_name");
		String itemDesc = mRequest.getParameter("item_desc");
		String likeIt = mRequest.getParameter("like_it");
		String originPrice = mRequest.getParameter("origin_price");
		String salePrice = mRequest.getParameter("sale_price");
		String image = mRequest.getFilesystemName("image");//바뀐 파일이름으로....
		
		ShopItem si = new ShopItem();
		si.setItemCode(itemCode);
		si.setItemName(itemName);
		si.setItemDesc(itemDesc);
		
		likeIt = likeIt == null ? "0" : likeIt;
		si.setLikeIt(Double.parseDouble(likeIt));
		originPrice = originPrice == null ? "0" : originPrice;
		si.setOriginPrice(Integer.parseInt(originPrice));
		salePrice = salePrice == null ? "0" : salePrice;
		si.setSalePrice(Integer.parseInt(salePrice));
		
		si.setImage(image);
		
		ShopDAO dao = new ShopDAO();
		dao.insertShopItem(si);
		
		
		System.out.println(itemCode);
//		doGet(request, response);
	}

}
