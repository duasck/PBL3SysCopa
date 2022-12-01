module PBL3 {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.junit.jupiter.api;
	requires javafx.base;
	requires javafx.graphics;
	
	opens app.control to javafx.graphics, javafx.fxml, javafx.base;
	opens app.model;
	exports app;
}
