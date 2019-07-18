package dashboard;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.CategoryDaoImpl;
import dao.WriterDao;
import dao.WriterDaoImpl;
import model.Category;
import model.Writer;

@WebServlet("/AdminDashBoardAddCategory")
public class AdminDashBoardAddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		WriterDao writerDao = new WriterDaoImpl();
		List<Writer> writerList = writerDao.getWriterList();
		request.setAttribute("writerList", writerList);
		RequestDispatcher req = request.getRequestDispatcher("editOthers.jsp");
		req.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = null;
		if (request.getParameter("editCategory") != null) {
			action = "EditCategory";
		} else if (request.getParameter("deleteCategory") != null) {
			action = "DeleteCategory";
		} else if (request.getParameter("editWriter") != null) {
			action = "EditWriter";
		} else if (request.getParameter("deleteWriter") != null) {
			action = "DeleteWriter";
		} else if (request.getParameter("addCategory") != null) {
			action = "AddCategory";
		} else if (request.getParameter("addWriter") != null) {
			action = "AddWriter";
		} else if (request.getParameter("editCategoryPage") != null) {
			action = "EditCategoryPage";
		} else if (request.getParameter("editWriterPage") != null) {
			action = "EditWriterPage";
		}

		try {
			if (action == "EditCategory") {
				editCategory(request, response);
			} else if (action == "DeleteCategory") {
				deleteCategory(request, response);
			} else if (action == "EditWriter") {
				editWriter(request, response);
			} else if (action == "DeleteWriter") {
				deleteWriter(request, response);
			} else if (action == "AddCategory") {
				addCategory(request, response);
			} else if (action == "AddWriter") {
				addWriter(request, response);
			} else if (action == "EditCategoryPage") {
				editCategoryPage(request, response);
			} else if (action == "EditWriterPage") {
				editWriterPage(request, response);
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void editCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		Integer categoryId = Integer.valueOf(request.getParameter("editCategory"));
		Category category = null;
		if (categoryId != null) {
			category = categoryDao.getCategory(categoryId);
		}
		if (categoryId != null) {
			List<Category> categoryList = new ArrayList<Category>();
			categoryList.add(category);
			request.setAttribute("categoryList", categoryList);

			RequestDispatcher req = request.getRequestDispatcher("categoryEdit.jsp");
			req.forward(request, response);
		} else {
			doGet(request, response);
		}
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("deleteCategory");
		Integer categoryId = Integer.valueOf(id);
		if (categoryId != null) {
			CategoryDao categoryDao = new CategoryDaoImpl();
			categoryDao.delete(categoryId);
		}
		doGet(request, response);
	}

	private void editWriter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WriterDao writerDao = new WriterDaoImpl();
		Integer writerId = Integer.valueOf(request.getParameter("editWriter"));
		Writer writer = null;
		if (writerId != null) {
			writer = writerDao.getWriter(writerId);
		}
		if (writerId != null) {
			List<Writer> writerList = new ArrayList<Writer>();
			writerList.add(writer);
			request.setAttribute("writerList", writerList);

			RequestDispatcher req = request.getRequestDispatcher("writerEdit.jsp");
			req.forward(request, response);
		} else {
			doGet(request, response);
		}

	}

	private void deleteWriter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("deleteWriter");
		Integer writerId = Integer.valueOf(id);
		if (writerId != null) {
			WriterDao writerDao = new WriterDaoImpl();
			writerDao.delete(writerId);
		}
		doGet(request, response);
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String categoryName = request.getParameter("categoryName");

		if (categoryName.isEmpty()) {
			doGet(request, response);
		} else {
			boolean insertSuccess = false;
			Category category = new Category(categoryName);

			CategoryDao categoryDao = new CategoryDaoImpl();
			insertSuccess = categoryDao.save(category);

			if (insertSuccess) {
				doGet(request, response);
			} else {
				doGet(request, response);
			}
		}
	}

	private void addWriter(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		String writerName = request.getParameter("writerName");
		writerName = writerName.replace(' ', '_');
		String gender = request.getParameter("gender");
		gender = gender.replace(' ', '_');

		LocalDate localBirthDate = LocalDate.parse(request.getParameter("birthDate"));
		Date birthDate = Date.valueOf(localBirthDate);

		if (writerName.isEmpty() || gender.isEmpty() || birthDate == null) {
			doGet(request, response);
		} else {
			boolean insertSuccess = false;
			Writer writer = new Writer(writerName, gender, birthDate);

			WriterDao writerDao = new WriterDaoImpl();
			insertSuccess = writerDao.save(writer);

			if (insertSuccess) {
				doGet(request, response);
			} else {
				doGet(request, response);
			}
		}
	}

	private void editCategoryPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void editWriterPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}