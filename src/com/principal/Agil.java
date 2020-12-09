package com.principal;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import com.menu.Menu;
import com.tabelas.Tabelas;

import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.Radio;
import totalcross.ui.RadioGroupController;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class Agil extends MainWindow{
	
	public static Edit						editEmpresa;
	public static Edit						editCnpj;

	public static  String					email = "";
	public static  String   				senha = "";
	public static  String   				salvarSenha = "";
		
	public static Edit 						editUsuario;
	public static Edit 						editSenha;

	public Button 							btnEntrar;
	public Button 							btnCadastrar;
	public Button 							btnSair;

	public ImageControl 					imgAlcateia;

	public Label 							lblSalvarSenha;
	public Radio 			   	    		radioSim, radioNao;
	public RadioGroupController				radioGrupo;
	
//	public ArtButton       		    		btnAdm;
	public ImageControl						imgHome;

	
	
	public static Container[] screens = new Container[1];
		
		
	public Agil() {
		
		super("AGIL", TAB_ONLY_BORDER);
		
		setBackColor(0x1c355d);
		Tabelas tabelas = new Tabelas();
		tabelas.criaTabelas();		
		Settings.applicationId   = "AGIL";
		Settings.appDescription  = "Ágil";
		Settings.appVersion 	 = Auxiliares.VERSAO;
		Settings.useNewFont 	 = Settings.fingerTouch = true;		
		Settings.dateFormat 	 = Settings.DATE_DMY;
		
//		Settings.resizableWindow = true;
		
	}
		
		public void initUI(){
			
		try {
			
            radioGrupo = new RadioGroupController();
			
			imgAlcateia = new ImageControl(new Image("img/logo.png"));
			imgAlcateia.scaleToFit = true;
			imgAlcateia.centerImage = true;
			add(imgAlcateia, CENTER, TOP + 10, SCREENSIZE + 30, SCREENSIZE + 30);

			editUsuario = new Edit();
			add(editUsuario);
			editUsuario.setRect(LEFT + 40, AFTER + 20, SCREENSIZE + 90, SCREENSIZE + 5);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x1c355d);
			editUsuario.setText("Usuário");

			editSenha = new Edit();
			add(editSenha);
			editSenha.setRect(LEFT + 40, AFTER + 10, SCREENSIZE + 90, SCREENSIZE + 5, editUsuario);
			editSenha.setBackColor(Color.WHITE);
			editSenha.setForeColor(0x1c355d);
			editSenha.setMode(Edit.PASSWORD_ALL);
			editSenha.setText("Senha");

			lblSalvarSenha = new Label("Salvar senha? ");
			add(lblSalvarSenha);
			lblSalvarSenha.setRect(CENTER, AFTER + 30, PREFERRED, PREFERRED, editSenha);
			lblSalvarSenha.setForeColor(Color.WHITE);
			
			radioSim = new Radio("Sim",radioGrupo);
		    add(radioSim);
			radioSim.setRect(AFTER + 10, SAME, PREFERRED, PREFERRED, lblSalvarSenha);
			radioSim.setForeColor(Color.WHITE);
			radioSim.setFont(Auxiliares.getFontGridBold());

			radioNao = new Radio("Não",radioGrupo);
			add(radioNao);
			radioNao.setRect(AFTER + 30, SAME, PREFERRED, PREFERRED, radioSim);	
			radioNao.setForeColor(Color.WHITE);
			radioNao.setFont(Auxiliares.getFontGridBold());

			btnEntrar = BottomImg.imageWithText(new Image("img/entrar.png"), "Entrar", Button.BOTTOM);
			add(btnEntrar, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnEntrar.setBackColor(0x1c355d);
			btnEntrar.setForeColor(Color.WHITE);

			btnSair = BottomImg.imageWithText(new Image("img/sair.png"), "Sair", Button.BOTTOM);
			add(btnSair, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnSair.setBackColor(0x1c355d);
			btnSair.setForeColor(Color.WHITE);
			
			reposition();
			
			buscaUsuarioCadastrado();
			
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao construir a tela principal\n" + e);
		}	
		
	}
		
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnEntrar) {

					if (editUsuario.getText().equals("Usuário") || editUsuario.getText().equals("")
							|| editSenha.getText().equals("Senha") || editSenha.getText().equals("")) {

						Auxiliares.messagebox("AGIL", "Usuário(a) incorreto!");
					} else {

						if (validaUsuarioCadastrado()) {
							Menu menu = new Menu();
							menu.popup();

						} else {
							Auxiliares.messagebox("AGIL",
									"Usuário(a) incorreto!");

						}
					}

				} else if (evt.target == btnSair) {

					String[] ArtButtonArray = { "Sim", "Não" };

					int i = Auxiliares.messageBox("AGIL", "Deseja sair do sistema?", ArtButtonArray);

					if (i == 1) {
						return;

					} else {
						Agil.exit(0);

					}
				}
				
			  case ControlEvent.FOCUS_IN:
				
				if (evt.target == editUsuario){

					if(editUsuario.getText().equals("E-mail")){
						editUsuario.setText("");

					}


				} else if(evt.target == editSenha){

					if(editSenha.getText().equals("Senha")){
						editSenha.setText("");

					}
				} else if(evt.target == radioSim) {
					atualizaTabelaUsuario("S");
				} else if(evt.target == radioNao) {
					atualizaTabelaUsuario("N");
				}
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela principal\n" + e);
		}

	}

	public static void buscaUsuarioCadastrado(){

		String sql 				 = "";
		LitebasePack lb 	     = null;
		ResultSet rs			 = null;

		try {

			try {
				lb = new LitebasePack();
				sql = "SELECT * FROM USUARIO ";

				rs = lb.executeQuery(sql);

				if (rs.getRowCount() > 0) {

					Auxiliares.NOMEUSUARIO = rs.getString("USUARIO");
					editUsuario.setText(rs.getString("USUARIO"));
					editSenha.setText(rs.getString("SENHA"));

				} else {
					Auxiliares.messagebox("SOLUCAO", "Não existe usuário(a) cadastrado!");
					editUsuario.setText("Usuário");
					return;
				}

			} finally {

				if (lb != null)
				lb.closeAll();

				if(rs != null)
				rs.close();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("Erro", "Erro buscaUsuarioCadastrado" + e);
			return;
		}
	}

		public boolean validaUsuarioCadastrado(){

			String sql 				     = "";
			LitebasePack lb 		     = null;
			ResultSet rs			     = null;
	
			try {
	
				try {
					lb = new LitebasePack();
					sql = "SELECT * FROM USUARIO ";
	
					rs = lb.executeQuery(sql);
	
					if (rs.getRowCount() > 0) {
						
						if(editUsuario.getText().equals(rs.getString("USUARIO")) && 
						editSenha.getText().equals(rs.getString("SENHA"))){
						 return true;
 
					 }else{

						 return false;
					 }

					}else{
						return false;
					}
					
				

				} finally {
	
					if (lb != null)
					lb.closeAll();
	
					if(rs != null)
					rs.close();
				}
	
			} catch (Exception e) {
				Auxiliares.messagebox("Erro", "Erro validaUsuarioCadastrado");
				return false;
			}
		}
		
		public void atualizaTabelaUsuario(String salvarSenha){

			String sql 					 = "";
			LitebasePack lb 	     = null;
	
			try {
	
				try {
					lb = new LitebasePack();
					sql = " UPDATE USUARIO "
					    + " SET SALVAR_SENHA = '" + salvarSenha + "'";
	
					lb.executeUpdate(sql);

				} finally {
	
					if (lb != null)
					lb.closeAll();
				}
	
			} catch (Exception e) {
				Auxiliares.messagebox("Erro", "Erro validaUsuarioCadastrado");
			}
		}
	
//------------> TITLE APP <-------------	
//	super("ARTVENDAS_IN", TAB_ONLY_BORDER);
//	 //super("ARTVENDAS_IN_II", TAB_ONLY_BORDER);
//	LitebasePack lb = null;
//	try {
//		lb = new LitebasePack();
//		lb.CheckAllTables();
//	} catch (Exception e) {
//		Auxiliares.artMsgbox("ERRO" + e.getMessage());
//	} finally {
//		if (lb != null)
//			lb.closeAll();
//	}
//
//	setBackColor(Color.WHITE);
//	UIColors.controlsBack = Color.WHITE;
//
//	// Instantiate the screens
//
//	UIColors.controlsBack = Color.WHITE;
//	Settings.uiAdjustmentsBasedOnFontHeight = true;
			
}
