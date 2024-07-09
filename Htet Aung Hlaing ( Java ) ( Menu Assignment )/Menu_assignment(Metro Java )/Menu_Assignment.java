package Myfx;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Menu_Assignment extends Application {
	
	
	private MenuBar bars = new MenuBar();
	private Menu mOperator = new Menu("Operator");
	private Menu mFormat = new Menu("Format Number");

	private RadioMenuItem mAddtion = new RadioMenuItem("Addtion");
	private RadioMenuItem mSubstration = new RadioMenuItem("Substraction");
	private RadioMenuItem mMultiply = new RadioMenuItem("Multiply");
	private RadioMenuItem mDivision = new RadioMenuItem("Divison");
	private RadioMenuItem mModuls = new RadioMenuItem("Modulus");
	private RadioMenuItem mExit = new RadioMenuItem("Exit");
	
	private RadioMenuItem mRound = new RadioMenuItem("Round");
	private RadioMenuItem mCeli  = new RadioMenuItem("Celi");
	private RadioMenuItem mFloor = new RadioMenuItem("Floor");
	
	private Label lblNo1 = new Label("Number 1");
	private TextField txtNo1 = new TextField();
	private Label lblNo2 = new Label("Number 2");
	private TextField txtNo2 = new TextField();
	private Label lblResult = new Label("Result");
	private TextField txtResult = new TextField();
	
	
	private Button btnAgain = new Button("Again");
	private Button btnClose = new Button("Closed");
	
 	
	
	BorderPane root = new BorderPane();
	GridPane tools = new GridPane();
	public static void main(String[] args) {
		launch(args);
	}
	
	public void again() {
		txtNo1.clear();
		txtNo2.clear();
		txtResult.clear();
		txtNo1.requestFocus();
		txtNo1.selectAll();
	}


	@Override
	public void start(Stage st) throws Exception {
		
		root.setTop(bars);
		root.setCenter(tools);

		bars.getMenus().addAll(mOperator,mFormat);
		mOperator.getItems().addAll(mAddtion,mSubstration,mMultiply,mDivision,mModuls,new SeparatorMenuItem() ,mExit);
		mFormat.getItems().addAll(mRound,mCeli,mFloor);
		
		mAddtion.setAccelerator(KeyCombination.valueOf("Ctrl + A"));
		mSubstration.setAccelerator(KeyCombination.valueOf("Ctrl + S"));
		mMultiply.setAccelerator(KeyCombination.valueOf("Ctrl + M"));
		mDivision.setAccelerator(KeyCombination.valueOf("Ctrl + D"));
		mModuls.setAccelerator(KeyCombination.valueOf("Ctrl + O"));
		
		tools.addColumn(0, lblNo1, lblNo2 , lblResult);
		tools.addColumn(1, txtNo1,txtNo2,txtResult);
		tools.setStyle("-fx-padding : 15px ; -fx-vgap:15px ; -fx-hgap: 15px;");
		
		tools.addColumn(1, btnAgain);
		tools.addColumn(1, btnClose);
		
		ToggleGroup gpTextFill = new ToggleGroup();
		gpTextFill.getToggles().addAll(mAddtion,mSubstration,mMultiply,mDivision,mModuls,mRound,mCeli,mFloor);
		
		
		
		
		Scene sc = new Scene(root);
		st.setScene(sc);
		st.setTitle("Menu Assignment");
		st.show();
		
		mAddtion.setOnAction(e->{
			double a,b,x;
			a = Double.parseDouble(txtNo1.getText().toString());
			b = Double.parseDouble(txtNo2.getText().toString());
			
			x = a+b ;
			txtResult.setText(x + "");
		});
		
		mSubstration.setOnAction(e->{
			double a,b,x;
			a = Double.parseDouble(txtNo1.getText().toString());
			b = Double.parseDouble(txtNo2.getText().toString());
			
			if(a>b)
				x = a-b ;
			else
				x = b-a ;
			txtResult.setText(x + "");
		});
		
		mDivision.setOnAction(e->{
			double a,b,x;
			a = Double.parseDouble(txtNo1.getText().toString());
			b = Double.parseDouble(txtNo2.getText().toString());
			
			if(a>b)
				x = a/b ;
			else
				x = b/a ;
			txtResult.setText(x + "");
		});
		
		mModuls.setOnAction(e->{
			double a,b,x;
			a = Double.parseDouble(txtNo1.getText().toString());
			b = Double.parseDouble(txtNo2.getText().toString());
			
			if(a>b)
				x = a%b ;
			else
				x = b%a ;
			txtResult.setText(x + "");
		});
		
		mMultiply.setOnAction(e->{
			double a,b,x;
			a = Double.parseDouble(txtNo1.getText().toString());
			b = Double.parseDouble(txtNo2.getText().toString());
			
			if(a>b)
				x = a*b ;
			else
				x = b*a ;
			txtResult.setText(x + "");
		});
		
		mRound.setOnAction(e->{
			double z = 0 ;
			if(!txtResult.getText().toString().trim().equals("")) {
				z = Math.round(Double.parseDouble(txtResult.getText().toString()));
			}
			txtResult.setText("" + z);
		});
		
		mRound.setOnAction(e->{
			double z = 0 ;
			if(!txtResult.getText().toString().trim().equals("")) {
				z = Math.round(Double.parseDouble(txtResult.getText().toString()));
			}
			txtResult.setText("" + z);
		});
		
		mCeli.setOnAction(e->{
			double z = 0 ;
			if(!txtResult.getText().toString().trim().equals("")) {
				z = Math.ceil(Double.parseDouble(txtResult.getText().toString()));
			}
			txtResult.setText("" + z);
		});
		
		mFloor.setOnAction(e->{
			double z = 0 ;
			if(!txtResult.getText().toString().trim().equals("")) {
				z = Math.floor(Double.parseDouble(txtResult.getText().toString()));
			}
			txtResult.setText("" + z);
		});
		
		btnAgain.setOnAction(e->again());
		btnClose.setOnAction(e->{System.exit(0);});
		
		
	}
	
	

}
