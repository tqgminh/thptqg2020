package application;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import comparator.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import object.*;
import rank.*;
import search.Searching;

public class SampleController implements Initializable {
	
	public ObservableList<Student> studentList;
	public TableView<Student> tableTop100 = new TableView<Student>();
	public TableColumn<Student, String> identificationTop100 = new TableColumn<Student, String>("Số báo danh");
	public TableColumn<Student, Double> mathTop100 = new TableColumn<Student, Double>("Toán");
	public TableColumn<Student, Double> literatureTop100 = new TableColumn<Student, Double>("Văn");
	public TableColumn<Student, Double> physicsTop100 = new TableColumn<Student, Double>("Lý");
	public TableColumn<Student, Double> chemistryTop100 = new TableColumn<Student, Double>("Hóa");
	public TableColumn<Student, Double> biologyTop100 = new TableColumn<Student, Double>("Sinh");
	public TableColumn<Student, Double> historyTop100 = new TableColumn<Student, Double>("Sử");
	public TableColumn<Student, Double> geographyTop100 = new TableColumn<Student, Double>("Địa");
	public TableColumn<Student, Double> physicalEducationTop100 = new TableColumn<Student, Double>("GDCD");
	public TableColumn<Student, Double> foreignerLanguageTop100 = new TableColumn<Student, Double>("Ngoại ngữ");
	public TableColumn<Student, String> codeForeignerLanguageTop100 = new TableColumn<Student, String>("Mã NN");
	public TableColumn<Student, Double> A00Top100 = new TableColumn<Student, Double>("Khối A00");
	public TableColumn<Student, Double> A01Top100 = new TableColumn<Student, Double>("Khối A01");
	public TableColumn<Student, Double> B00Top100 = new TableColumn<Student, Double>("Khối B00");
	public TableColumn<Student, Double> C00Top100 = new TableColumn<Student, Double>("Khối C00");
	public TableColumn<Student, Double> D01Top100 = new TableColumn<Student, Double>("Khối D01");
	
	@FXML
	public TextField inputSearch;
	
	@FXML
	public TableView<Student> tableScore;
	
	@FXML
	public TableView<Student> tableCombination;
	
	@FXML
	public TableColumn<Student, String> identification;
	
	@FXML
	public TableColumn<Student, Double> math;
	
	@FXML
	public TableColumn<Student, Double> literature;
	
	@FXML
	public TableColumn<Student, Double> physics;
	
	@FXML
	public TableColumn<Student, Double> chemistry;
	
	@FXML
	public TableColumn<Student, Double> biology;
	
	@FXML
	public TableColumn<Student, Double> history;
	
	@FXML
	public TableColumn<Student, Double> geography;
	
	@FXML
	public TableColumn<Student, Double> physicalEducation;
	
	@FXML
	public TableColumn<Student, Double> foreignerLanguage;
	
	@FXML
	public TableColumn<Student, String> codeForeignerLanguage;
	
	@FXML
	public TableColumn<Student, Double> A00;
	
	@FXML
	public TableColumn<Student, Double> A01;
	
	@FXML
	public TableColumn<Student, Double> B00;
	
	@FXML
	public TableColumn<Student, Double> C00;
	
	@FXML
	public TableColumn<Student, Double> D01;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		studentList = FXCollections.observableArrayList();
		//top100Math = FXCollections.observableArrayList();
		identification.setCellValueFactory(new PropertyValueFactory<Student, String>("identification"));
		math.setCellValueFactory(new PropertyValueFactory<Student, Double>("math"));
		literature.setCellValueFactory(new PropertyValueFactory<Student, Double>("literature"));
		physics.setCellValueFactory(new PropertyValueFactory<Student, Double>("physics"));
		chemistry.setCellValueFactory(new PropertyValueFactory<Student, Double>("chemistry"));
		biology.setCellValueFactory(new PropertyValueFactory<Student, Double>("biology"));
		history.setCellValueFactory(new PropertyValueFactory<Student, Double>("history"));
		geography.setCellValueFactory(new PropertyValueFactory<Student, Double>("geography"));
		physicalEducation.setCellValueFactory(new PropertyValueFactory<Student, Double>("physicalEducation"));
		foreignerLanguage.setCellValueFactory(new PropertyValueFactory<Student, Double>("foreignerLanguage"));
		codeForeignerLanguage.setCellValueFactory(new PropertyValueFactory<Student, String>("codeForeignerLanguage"));
		A00.setCellValueFactory(new PropertyValueFactory<Student, Double>("A00"));
		A01.setCellValueFactory(new PropertyValueFactory<Student, Double>("A01"));
		B00.setCellValueFactory(new PropertyValueFactory<Student, Double>("B00"));
		C00.setCellValueFactory(new PropertyValueFactory<Student, Double>("C00"));
		D01.setCellValueFactory(new PropertyValueFactory<Student, Double>("D01"));
		tableScore.setItems(studentList);
		tableCombination.setItems(studentList);
	}
	
	public void top100() {
		//studentList = FXCollections.observableArrayList();
		//top100Math = FXCollections.observableArrayList();
		identificationTop100.setCellValueFactory(new PropertyValueFactory<Student, String>("identification"));
		mathTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("math"));
		literatureTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("literature"));
		physicsTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("physics"));
		chemistryTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("chemistry"));
		biologyTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("biology"));
		historyTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("history"));
		geographyTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("geography"));
		physicalEducationTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("physicalEducation"));
		foreignerLanguageTop100.setCellValueFactory(new PropertyValueFactory<Student, Double>("foreignerLanguage"));
		codeForeignerLanguageTop100.setCellValueFactory(new PropertyValueFactory<Student, String>("codeForeignerLanguage"));
		A00Top100.setCellValueFactory(new PropertyValueFactory<Student, Double>("A00"));
		A01Top100.setCellValueFactory(new PropertyValueFactory<Student, Double>("A01"));
		B00Top100.setCellValueFactory(new PropertyValueFactory<Student, Double>("B00"));
		C00Top100.setCellValueFactory(new PropertyValueFactory<Student, Double>("C00"));
		D01Top100.setCellValueFactory(new PropertyValueFactory<Student, Double>("D01"));
		tableTop100.setItems(studentList);
	}
	
	public void pressSearch(ActionEvent event) throws NumberFormatException, IOException {
		String sbd = inputSearch.getText();
		Searching search = new Searching();
		Student std = search.searchStudent(sbd);
		if(std == null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Không tìm thấy số báo danh của bạn. Vui lòng nhập lại");
			alert.show();
			studentList.removeAll(studentList);
		}
		else {
			studentList.removeAll(studentList);
			studentList.add(std);
		}
		inputSearch.setText("");
	}
	
	public void pressA00Ranking(ActionEvent event) throws NumberFormatException, IOException {
		A00Ranking a00ranking = new A00Ranking();
		if(studentList.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Không tìm thấy số báo danh của bạn. Vui lòng nhập lại");
			alert.show();
			//studentList.removeAll(studentList);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(a00ranking.rankingA00(studentList.get(0)));
			alert.show();
			//studentList.removeAll(studentList);
		}
	}
	
	public void pressA01Ranking(ActionEvent event) throws NumberFormatException, IOException {
		A01Ranking a01ranking = new A01Ranking();
		if(studentList.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Không tìm thấy số báo danh của bạn. Vui lòng nhập lại");
			alert.show();
			//studentList.removeAll(studentList);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(a01ranking.rankingA01(studentList.get(0)));
			alert.show();
			//studentList.removeAll(studentList);
		}
	}
	
	public void pressB00Ranking(ActionEvent event) throws NumberFormatException, IOException {
		B00Ranking b00ranking = new B00Ranking();
		if(studentList.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Không tìm thấy số báo danh của bạn. Vui lòng nhập lại");
			alert.show();
			//studentList.removeAll(studentList);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(b00ranking.rankingB00(studentList.get(0)));
			alert.show();
			//studentList.removeAll(studentList);
		}
	}
	
	public void pressC00Ranking(ActionEvent event) throws NumberFormatException, IOException {
		C00Ranking c00ranking = new C00Ranking();
		if(studentList.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Không tìm thấy số báo danh của bạn. Vui lòng nhập lại");
			alert.show();
			//studentList.removeAll(studentList);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(c00ranking.rankingC00(studentList.get(0)));
			alert.show();
			//studentList.removeAll(studentList);
		}
	}
	
	public void pressD01Ranking(ActionEvent event) throws NumberFormatException, IOException {
		D01Ranking d01ranking = new D01Ranking();
		if(studentList.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Không tìm thấy số báo danh của bạn. Vui lòng nhập lại");
			alert.show();
			//studentList.removeAll(studentList);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(d01ranking.rankingD01(studentList.get(0)));
			alert.show();
			//studentList.removeAll(studentList);
		}
	}
	
	public void pressTop100Math(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new MathComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Toán cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100Literature(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, literatureTop100, mathTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new LiteratureComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Văn cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100Physics(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, physicsTop100, mathTop100, literatureTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new PhysicsComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Lý cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100Chemistry(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, chemistryTop100, mathTop100, literatureTop100, physicsTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new ChemistryComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Hóa cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100Biology(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, biologyTop100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new BiologyComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Sinh cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100History(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, historyTop100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new HistoryComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Sử cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100Geography(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, geographyTop100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new GeographyComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Địa cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100PhysicalEducation(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, physicalEducationTop100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		Searching searching = new Searching();
		Collections.sort(searching.student, new PhysicalEducationComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn GDCD cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100English(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100);
		Searching searching = new Searching("N1");
		Collections.sort(searching.student, new EnglishComparator());
		for(int i = 1; i <= 100; i++)
			studentList.add(searching.student.get(searching.student.size()-i));
		tableTop100.setItems(studentList);
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm môn Tiếng Anh cao nhất");
	    Scene scene = new Scene(root, 590, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100A00(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, A00Top100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		A00Ranking a00ranking = new A00Ranking();
		for(int i = 0; i < 100; i++)
			studentList.add(a00ranking.student.get(i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm tổ hợp khối A00 cao nhất");
	    Scene scene = new Scene(root, 630, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100A01(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, A01Top100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		A01Ranking a01ranking = new A01Ranking();
		for(int i = 0; i < 100; i++)
			studentList.add(a01ranking.student.get(i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm tổ hợp khối A01 cao nhất");
	    Scene scene = new Scene(root, 630, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100B00(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, B00Top100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		B00Ranking b00ranking = new B00Ranking();
		for(int i = 0; i < 100; i++)
			studentList.add(b00ranking.student.get(i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm tổ hợp khối B00 cao nhất");
	    Scene scene = new Scene(root, 630, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100C00(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, C00Top100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		C00Ranking c00ranking = new C00Ranking();
		for(int i = 0; i < 100; i++)
			studentList.add(c00ranking.student.get(i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm tổ hợp khối C00 cao nhất");
	    Scene scene = new Scene(root, 630, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressTop100D01(ActionEvent event) throws NumberFormatException, IOException {
		tableTop100.getColumns().clear();
		studentList.removeAll(studentList);
		this.top100();
		tableTop100.getColumns().addAll(identificationTop100, D01Top100, mathTop100, literatureTop100, physicsTop100, chemistryTop100, biologyTop100, historyTop100, geographyTop100, physicalEducationTop100, foreignerLanguageTop100, codeForeignerLanguageTop100);
		D01Ranking d01ranking = new D01Ranking();
		for(int i = 0; i < 100; i++)
			studentList.add(d01ranking.student.get(i));
		StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    root.getChildren().add(tableTop100);
	    Stage stage = new Stage();
	    stage.setTitle("Top 100 thí sinh có điểm tổ hợp khối D01 cao nhất");
	    Scene scene = new Scene(root, 630, 600);
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void pressMathChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		MathStudent mathstd = new MathStudent();
		for(int i = 0; i < 51; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(mathstd.score[i], mathstd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Toán kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Toán kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressLiteratureChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		LiteratureStudent literstd = new LiteratureStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(literstd.score[i], literstd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Văn kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Văn kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressPhysicsChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		PhysicsStudent physstd = new PhysicsStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(physstd.score[i], physstd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Lý kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Lý kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressChemistryChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		ChemistryStudent chemstd = new ChemistryStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(chemstd.score[i], chemstd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Hóa kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Hóa kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressBiologyChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		BiologyStudent biostd = new BiologyStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(biostd.score[i], biostd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Sinh kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Sinh kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressHistoryChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		HistoryStudent hisstd = new HistoryStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(hisstd.score[i], hisstd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Sử kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Sử kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressGeographyChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		GeographyStudent geostd = new GeographyStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(geostd.score[i], geostd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Địa kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Địa kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressPhysicalEducationChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		PhysicalEducationStudent phyedustd = new PhysicalEducationStudent();
		for(int i = 0; i < 41; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(phyedustd.score[i], phyedustd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn GDCD kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn GDCD kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressEnglishChart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		EnglishStudent engstd = new EnglishStudent();
		for(int i = 0; i < 51; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(engstd.score[i], engstd.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm môn Tiếng Anh kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm môn Tiếng Anh kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressA00Chart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		A00Student a00std = new A00Student();
		for(int i = 0; i < 30; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(a00std.score[i], a00std.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm khối A00 kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm khối A00 kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressA01Chart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		A01Student a01std = new A01Student();
		for(int i = 0; i < 30; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(a01std.score[i], a01std.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm khối A01 kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm khối A01 kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressB00Chart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		B00Student b00std = new B00Student();
		for(int i = 0; i < 30; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(b00std.score[i], b00std.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm khối B00 kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm khối B00 kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressC00Chart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		C00Student c00std = new C00Student();
		for(int i = 0; i < 30; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(c00std.score[i], c00std.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm khối C00 kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm khối C00 kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
	
	public void pressD01Chart(ActionEvent event) throws NumberFormatException, IOException {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
		D01Student d01std = new D01Student();
		for(int i = 0; i < 30; i++) {
			dataSeries.getData().add(new XYChart.Data<String, Number>(d01std.score[i], d01std.number[i]));
		}
		barChart.getData().add(dataSeries);
		barChart.setTitle("Phổ điểm khối D01 kỳ thi THPT quốc gia năm 2020");
		VBox vbox = new VBox(barChart);
		Stage stage = new Stage();
		stage.setTitle("Phổ điểm khối D01 kỳ thi THPT quốc gia năm 2020");
	    Scene scene = new Scene(vbox, 800, 500);
	    stage.setScene(scene);
	    stage.setHeight(500);
	    stage.setWidth(900);
	    stage.show();
	}
}
