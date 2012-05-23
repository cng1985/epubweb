package com.baoyi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.rpc.server.JsonRpcExecutor;
import org.json.rpc.server.JsonRpcServletTransport;
import org.springframework.beans.factory.BeanFactory;

import com.baoyi.factory.ObjectFactory;
/**
 * Servlet implementation class Json_Rpc
 */
@WebServlet("/jsonrpc")
public class Json_Rpc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final JsonRpcExecutor executor;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Json_Rpc() {
		super();
		executor = bind();
	}

	@SuppressWarnings("unchecked")
	private JsonRpcExecutor bind() {
		BeanFactory factory = ObjectFactory.getInstance();
//		JsonRpcExecutor executor = new JsonRpcExecutor();
//		MusicDao musicDao = factory.getBean("musicDao", MusicDao.class);
//		executor.addHandler("musicDao", musicDao, MusicDao.class);
//		MusicRpc musicRpcImpl = factory.getBean("musicRpcImpl", MusicRpc.class);
//		executor.addHandler("musicRpcImpl", musicRpcImpl, MusicRpc.class);
//		HotRpc hotRpcImpl = factory.getBean("hotRpcImpl", HotRpc.class);
//		executor.addHandler("hotRpcImpl", hotRpcImpl, HotRpc.class);
		return executor;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		executor.execute(new JsonRpcServletTransport(request, response));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		executor.execute(new JsonRpcServletTransport(request, response));
	}

}
