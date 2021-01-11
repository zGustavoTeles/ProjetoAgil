package com.cadastroDeAnimais;

import com.agenda.Agenda;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;
import totalcross.util.Random;

public class CadastroDeAnimais extends totalcross.ui.Window{
	
    private Button							btnCadastrar;
    private Button							btnDeletar;
    private Button							btnVoltar;
    
    public Label 							lblDescricao;
    public Label 							lblIdade;
    public Label 							lblSexo;
    public Label 							lblRaca;
    public Label 							lblPeso;
    public Label 							lblDataCompra;
    public Label 							lblPrecoCompra;
    public Label 							lblPrecoVenda;
    public Label 							lblVendaPerda;
//    public Label 							lblMesesAtual;
//    public Label 							lblCategoriaMeses;
    public Label 							lblStatus;
    public Label 							lblPastagem;
    public Label 							lblQuantidade;
    
    public Label 							lblAftosa;
    public Label 							lblRaiva;
    
    public Edit 							editDescricao;
    public Edit								editPrecoCompra;
    public Edit								editPrecoVenda;
    public Edit								editDataCompra;
    public Edit								editPastagem;
    public Edit								editIdade;
    public Edit								editQuantidade;
    
    public ComboBox							cmbSexo;
    public ComboBox							cmbRaca;
    public ComboBox							cmbPeso;
    public ComboBox							cmbDataCompra;
    public ComboBox							cmbStatus;
    
    public ComboBox							cmbAftosa;
    public ComboBox							cmbRaiva;
    

	
	public CadastroDeAnimais(){ 
		super("CADASTRO DE ANIMAIS", TAB_ONLY_BORDER);
		 setBackColor(0x1c355d);
		 initUI();
		 carregaCmbSexo();
		 carregaCmbRaca();
		 carregaCmbStatus();
		 carregaCmbAlternativa(); 
	}
	
	public void initUI() {
		
		try {
			
			lblDescricao = new Label("DESCRIÇÃO:");
			add(lblDescricao);
			lblDescricao.setRect(LEFT + 180, TOP + 30, PREFERRED, PREFERRED);
			lblDescricao.setForeColor(Color.WHITE);
			lblDescricao.setFont(Auxiliares.getFontBold());
			
			editDescricao = new Edit();			
			add(editDescricao);
			editDescricao.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblDescricao);
			editDescricao.setBackColor(Color.WHITE);
			editDescricao.setForeColor(0x1c355d);
			editDescricao.capitalise = (Edit.ALL_UPPER);
			editDescricao.setValidChars("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0");
			
			lblQuantidade = new Label("QUANTIDADE:");
			add(lblQuantidade);
			lblQuantidade.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblQuantidade.setForeColor(Color.WHITE);
			lblQuantidade.setFont(Auxiliares.getFontBold());
			
			editQuantidade = new Edit();			
			add(editQuantidade);
			editQuantidade.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblQuantidade);
			editQuantidade.setBackColor(Color.WHITE);
			editQuantidade.setForeColor(0x1c355d);
			editQuantidade.setValidChars("0123456789");
			
			lblIdade = new Label("IDADE:");
			add(lblIdade);
			lblIdade.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblIdade.setForeColor(Color.WHITE);
			lblIdade.setFont(Auxiliares.getFontBold());
			
			editIdade = new Edit();			
			add(editIdade);
			editIdade.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblIdade);
			editIdade.setBackColor(Color.WHITE);
			editIdade.setForeColor(0x1c355d);
			editIdade.capitalise = (Edit.ALL_UPPER);
			editIdade.setValidChars("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0");
			
			lblSexo = new Label("SEXO:");
			add(lblSexo);
			lblSexo.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblSexo.setForeColor(Color.WHITE);
			lblSexo.setFont(Auxiliares.getFontBold());
			
			cmbSexo = new ComboBox();			
			add(cmbSexo);
			cmbSexo.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblSexo);
			cmbSexo.setBackColor(Color.WHITE);
			cmbSexo.setForeColor(0x1c355d);
			
			lblRaca = new Label("RAÇA:");
			add(lblRaca);
			lblRaca.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblRaca.setForeColor(Color.WHITE);
			lblRaca.setFont(Auxiliares.getFontBold());
			
			cmbRaca = new ComboBox();			
			add(cmbRaca);
			cmbRaca.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblRaca);
			cmbRaca.setBackColor(Color.WHITE);
			cmbRaca.setForeColor(0x1c355d);
			
			lblDataCompra = new Label("DATA DA COMPRA:");
			add(lblDataCompra);
			lblDataCompra.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblDataCompra.setForeColor(Color.WHITE);
			lblDataCompra.setFont(Auxiliares.getFontBold());
			
			editDataCompra = new Edit();			
			add(editDataCompra);
			editDataCompra.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblDataCompra);
			editDataCompra.setBackColor(Color.WHITE);
			editDataCompra.setForeColor(0x1c355d);
			
			/*
			 * Trecho comentado para ser habilitado quando for necessário
			 * o uso do peso para o animal
			 */
			
//			lblPeso = new Label("PESO (KGS):");
//			add(lblPeso);
//			lblPeso.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
//			lblPeso.setForeColor(Color.WHITE);
//			lblPeso.setFont(Auxiliares.getFontBold());
//			
//			cmbPeso = new ComboBox();			
//			add(cmbPeso);
//			cmbPeso.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblPeso);

			
			lblPrecoCompra = new Label("PREÇO DE COMPRA:");
			add(lblPrecoCompra);
			lblPrecoCompra.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblPrecoCompra.setForeColor(Color.WHITE);
			lblPrecoCompra.setFont(Auxiliares.getFontBold());
			
			editPrecoCompra = new Edit();			
			add(editPrecoCompra);
			editPrecoCompra.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblPrecoCompra);
			editPrecoCompra.setBackColor(Color.WHITE);
			editPrecoCompra.setForeColor(0x1c355d);
			editPrecoCompra.setValidChars("0123456789,");
			
			lblPrecoVenda = new Label("PREÇO DE VENDA:");
			add(lblPrecoVenda);
			lblPrecoVenda.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblPrecoVenda.setForeColor(Color.WHITE);
			lblPrecoVenda.setFont(Auxiliares.getFontBold());
			
			editPrecoVenda = new Edit();			
			add(editPrecoVenda);
			editPrecoVenda.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblPrecoVenda);
			editPrecoVenda.setBackColor(Color.WHITE);
			editPrecoVenda.setForeColor(0x1c355d);
			editPrecoVenda.setValidChars("0123456789,");
			
			lblStatus = new Label("STATUS:");
			add(lblStatus);
			lblStatus.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblStatus.setForeColor(Color.WHITE);
			lblStatus.setFont(Auxiliares.getFontBold());
			
			cmbStatus = new ComboBox();			
			add(cmbStatus);
			cmbStatus.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblStatus);
			cmbStatus.setBackColor(Color.WHITE);
			cmbStatus.setForeColor(0x1c355d);
			
			lblPastagem = new Label("PASTAGEM:");
			add(lblPastagem);
			lblPastagem.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblPastagem.setForeColor(Color.WHITE);
			lblPastagem.setFont(Auxiliares.getFontBold());
			
			editPastagem = new Edit();			
			add(editPastagem);
			editPastagem.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblPastagem);
			editPastagem.setBackColor(Color.WHITE);
			editPastagem.setForeColor(0x1c355d);
			editPastagem.capitalise = (Edit.ALL_UPPER);
			editPastagem.setValidChars("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0");
			
			lblAftosa = new Label("VACINA C/ AFTOSA:");
			add(lblAftosa);
			lblAftosa.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblAftosa.setForeColor(Color.WHITE);
			lblAftosa.setFont(Auxiliares.getFontBold());
			
			cmbAftosa = new ComboBox();			
			add(cmbAftosa);
			cmbAftosa.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblAftosa);
			cmbAftosa.setBackColor(Color.WHITE);
			cmbAftosa.setForeColor(0x1c355d);
			
			lblRaiva = new Label("VACINA C/ RAIVA:");
			add(lblRaiva);
			lblRaiva.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblRaiva.setForeColor(Color.WHITE);
			lblRaiva.setFont(Auxiliares.getFontBold());
			
			cmbRaiva = new ComboBox();			
			add(cmbRaiva);
			cmbRaiva.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblRaiva);
			cmbRaiva.setBackColor(Color.WHITE);
			cmbRaiva.setForeColor(0x1c355d);
			
			btnCadastrar = BottomImg.imageWithText(new Image("img/cadastrar.png"), "Cadastrar", Button.BOTTOM);
			add(btnCadastrar, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnCadastrar.setBackColor(0x1c355d);
			btnCadastrar.setForeColor(Color.WHITE);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
            btnVoltar.setForeColor(Color.WHITE);

			reposition();
			editDescricao.requestFocus();
			
		} catch (Exception e) {

			Auxiliares.messagebox("Erro", "construir a tela CadastrarUsuario");
		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnCadastrar) {

					if (!editDescricao.getText().equals("") && !editQuantidade.getText().equals("")
							&& !editIdade.getText().equals("") && !cmbSexo.getSelectedItem().toString().equals("")
							&& !cmbRaca.getSelectedItem().toString().equals("") && !editDataCompra.getText().equals("")
							&& !editPrecoCompra.getText().equals("") && !editPrecoVenda.getText().equals("")
							&& !cmbStatus.getSelectedItem().toString().equals("") && !editPastagem.getText().equals("")
							&& !cmbAftosa.getSelectedItem().toString().equals("")
							&& !cmbRaiva.getSelectedItem().toString().equals("")) {

						if (editPrecoCompra.getText().equals(".0") || editPrecoCompra.getText().equals(".1")
								|| editPrecoCompra.getText().equals(".2") || editPrecoCompra.getText().equals(".3")
								|| editPrecoCompra.getText().equals(".4") || editPrecoCompra.getText().equals(".5")
								|| editPrecoCompra.getText().equals(".6") || editPrecoCompra.getText().equals(".7")
								|| editPrecoCompra.getText().equals(".8") || editPrecoCompra.getText().equals(".9")

								|| editPrecoVenda.getText().equals(".0") || editPrecoVenda.getText().equals(".1")
								|| editPrecoVenda.getText().equals(".2") || editPrecoVenda.getText().equals(".3")
								|| editPrecoVenda.getText().equals(".4") || editPrecoVenda.getText().equals(".5")
								|| editPrecoVenda.getText().equals(".6") || editPrecoVenda.getText().equals(".7")
								|| editPrecoVenda.getText().equals(".8") || editPrecoVenda.getText().equals(".9")) {

							Auxiliares.messagebox("AGIL", "Valor inserido incorreto!\n tente '2.23', por exemplo... ");
							return;
						}

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja cadastrar esse animal(s)?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {
							cadastraAnimal();

							Auxiliares.messagebox("AGIL", "Animal(s) cadastro com sucesso!");

							editDescricao.setText("");
							editQuantidade.setText("");
							editIdade.setText("");
							cmbSexo.removeAll();
							cmbRaca.removeAll();
							editDataCompra.setText("");
							editPrecoCompra.setText("");
							editPrecoVenda.setText("");
							cmbStatus.removeAll();
							editPastagem.setText("");
							cmbAftosa.removeAll();
							cmbRaiva.removeAll();

							carregaCmbSexo();
							carregaCmbRaca();
							carregaCmbStatus();
							carregaCmbAlternativa();

						}
					} else {
						Auxiliares.messagebox("AGIL", "Por favor preencha todos os campos!");
					}

				} else if (evt.target == btnVoltar) {
					unpop();

				}

			case PenEvent.PEN_DOWN:

				if (evt.target == editDataCompra) {
					Agenda.setDateByCalendarBox(editDataCompra);

				}

			}
		} catch (Exception e) {
			/*
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela carrinho\n" + e);
			*/
		}

	}
	
	public void carregaCmbSexo() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM SEXO";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbSexo.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbSexo\n" + e);

			}

		}
	}
	
	public void carregaCmbRaca() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM RACA";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbRaca.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbSexo\n" + e);

			}

		}
	}
	
	public void carregaCmbStatus() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM STATUS";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbStatus.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbSexo\n" + e);

			}

		}
	}

	public void carregaCmbAlternativa() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM ALTERNATIVA";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbAftosa.add(b);
						cmbRaiva.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbAlternativa\n" + e);

			}

		}
	}
	
	public void cadastraAnimal() {
		
		String sql 					= "";	
		LitebasePack lb 			= null;
		String dataCompra  			= "";

		try {
			Random random = new Random();
			int codigo = random.nextInt(900);
			dataCompra = new Date(editDataCompra.getText()).toString(Settings.DATE_DMY);

			lb = new LitebasePack();

			sql = "INSERT INTO REBANHO " + "(" + " CODIGO, DESCRICAO, QUANTIDADE, IDADE, SEXO, RACA, PESO, DATACOMPRA,"
					+ " PRECOCOMPRA, " + " PRECOVENDA, " + " STATUS, " + " PASTAGEM, " + "AFTOSA, " + "RAIVA " + ")"
					+ " VALUES " + "( '" + codigo + "', '" + editDescricao.getText() + "', '" 
					+ editQuantidade.getText() + "', '" + editIdade.getText() + "', '" + cmbSexo.getSelectedItem()
					+ "', '" + cmbRaca.getSelectedItem() + "', '" + 0 + "'" + ", '" + dataCompra + "'" + ", '"
					+ editPrecoCompra.getText() + "'" + ", '" + editPrecoVenda.getText() + "'" + ", '"
					+ cmbStatus.getSelectedItem() + "', '" + editPastagem.getText() + "'" + ", '"
					+ cmbAftosa.getSelectedItem() + "'" + ", '" + cmbRaiva.getSelectedItem() + "'" + ")";

			lb.executeUpdate(sql);

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao cadastraAnimal\n" + e);
			return;
		}

	}
}