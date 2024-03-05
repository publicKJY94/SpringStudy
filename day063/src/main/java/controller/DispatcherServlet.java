package controller;

import java.io.IOException;

import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	// init-method
	// 1. 멤버변수 초기화
	// 2. 생성자
	// 3. setter
	// 4. @Autowired
	// 5. DI(의존 주입)
	public void init() {
		handlerMapping=new HandlerMapping();
		viewResolver=new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String commend=uri.substring(cp.length());
		System.out.println("FC : "+commend);

		XXXControllerXXX controller=handlerMapping.getController(commend);
		String view = controller.execute(request, response);

		if(view.contains(".do")) {
			view=viewResolver.getView(view);
		}
		response.sendRedirect(view);

	}
}
