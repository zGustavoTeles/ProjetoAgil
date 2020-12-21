package com.tabelaDeAnimais;

import com.agenda.Agenda;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import com.principal.Agil;
import com.sun.org.apache.bcel.internal.generic.IDIV;

import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;
import totalcross.util.Random;

public class AlterarAnimal extends totalcross.ui.Window{
	
    private Button							btnAtualizar;
    private Button							btnDeletar;
    private Button							btnVoltar;
    
    public Label 							lblDescricao;
    public Label 							lblIdade;
    public Label 							lblSexo;
    public Label 							lblRaca;
    public Label 							lblPeso;
    public Label 							lblDataCompra;
    public Label 							lblPrecoCompra;
    public Label 							lblPrecoAtual;
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
    public Edit								editPrecoAtual;
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
    

	
	public AlterarAnimal(){ 
		super("ALTERAR ANIMAL (S)", TAB_ONLY_BORDER);
		 setBackColor(0x1c355d);
		 initUI();
		 carregaCmbSexo();
		 carregaCmbRaca();
		 carregaCmbStatus();
		 carregaCmbAlternativa(); 
		 carregaInfoAnimal();
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
			editPrecoCompra.setValidChars("0123456789,.");
			
			lblPrecoAtual = new Label("PREÇO ATUAL:");
			add(lblPrecoAtual);
			lblPrecoAtual.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblPrecoAtual.setForeColor(Color.WHITE);
			lblPrecoAtual.setFont(Auxiliares.getFontBold());
			
			editPrecoAtual = new Edit();			
			add(editPrecoAtual);
			editPrecoAtual.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblPrecoAtual);
			editPrecoAtual.setBackColor(Color.WHITE);
			editPrecoAtual.setForeColor(0x1c355d);
			editPrecoAtual.setValidChars("0123456789,.");
			
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
			
			btnAtualizar = BottomImg.imageWithText(new Image("img/alterar.png"), "Alterar", Button.BOTTOM);
			add(btnAtualizar, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnAtualizar.setBackColor(0x1c355d);
			btnAtualizar.setForeColor(Color.WHITE);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
            btnVoltar.setForeColor(Color.WHITE);

			reposition();
			
		} catch (Exception e) {

			Auxiliares.messagebox("Erro", "construir a tela AlterarAnimal");
		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnAtualizar) {

					if (!editDescricao.getText().equals("") && !editQuantidade.getText().equals("")
							&& !editIdade.getText().equals("") && !cmbSexo.getSelectedItem().toString().equals("")
							&& !cmbRaca.getSelectedItem().toString().equals("") && !editDataCompra.getText().equals("")
							&& !editPrecoCompra.getText().equals("") && !editPrecoAtual.getText().equals("")
							&& !cmbStatus.getSelectedItem().toString().equals("") && !editPastagem.getText().equals("")
							&& !cmbAftosa.getSelectedItem().toString().equals("")
							&& !cmbRaiva.getSelectedItem().toString().equals("")) {

						if (editPrecoCompra.getText().equals(".0") || editPrecoCompra.getText().equals(".1")
								|| editPrecoCompra.getText().equals(".2") || editPrecoCompra.getText().equals(".3")
								|| editPrecoCompra.getText().equals(".4") || editPrecoCompra.getText().equals(".5")
								|| editPrecoCompra.getText().equals(".6") || editPrecoCompra.getText().equals(".7")
								|| editPrecoCompra.getText().equals(".8") || editPrecoCompra.getText().equals(".9")

								|| editPrecoAtual.getText().equals(".0") || editPrecoAtual.getText().equals(".1")
								|| editPrecoAtual.getText().equals(".2") || editPrecoAtual.getText().equals(".3")
								|| editPrecoAtual.getText().equals(".4") || editPrecoAtual.getText().equals(".5")
								|| editPrecoAtual.getText().equals(".6") || editPrecoAtual.getText().equals(".7")
								|| editPrecoAtual.getText().equals(".8") || editPrecoAtual.getText().equals(".9")) {

							Auxiliares.messagebox("AGIL", "Valor inserido incorreto!\n tente '2.23', por exemplo... ");
							return;
						}

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja atualizar esse cadastro de animal(s)?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {
							cadastraAnimal();

							Auxiliares.messagebox("AGIL", "Cadastro de animal(s) atualizado com sucesso!");

							editDescricao.setText("");
							editQuantidade.setText("");
							editIdade.setText("");
							cmbSexo.removeAll();
							cmbRaca.removeAll();
							editDataCompra.setText("");
							editPrecoCompra.setText("");
							editPrecoAtual.setText("");
							cmbStatus.removeAll();
							editPastagem.setText("");
							cmbAftosa.removeAll();
							cmbRaiva.removeAll();

							carregaCmbSexo();
							carregaCmbRaca();
							carregaCmbStatus();
							carregaCmbAlternativa();
							
							TabelaDeAnimais.buscaAnimaisCadastrados();
							
							unpop();
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
	
	public void carregaInfoAnimal() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT * FROM REBANHO "
						+ " WHERE CODIGO = " + TabelaDeAnimais.codigoRebanho;

					rs = lb.executeQuery(sql);
					rs.first();
					
					editDescricao.setText(rs.getString("DESCRICAO"));
					editQuantidade.setText(Convert.toString(rs.getInt("QUANTIDADE")));
					editIdade.setText(rs.getString("IDADE"));				
					
					if (rs.getString("SEXO").equals("MACHO")) {
						cmbSexo.setSelectedIndex(0);
					} else {
						cmbSexo.setSelectedIndex(1);
					}
					
					if (rs.getString("RACA").equals("GIROLANDO")) {
						cmbRaca.setSelectedIndex(0);

					} else if (rs.getString("RACA").equals("GUZERA")) {
						cmbRaca.setSelectedIndex(1);

					} else if (rs.getString("RACA").equals("HOLANDES")) {
						cmbRaca.setSelectedIndex(2);

					} else if (rs.getString("RACA").equals("NELORE")) {
						cmbRaca.setSelectedIndex(3);

					} else if (rs.getString("RACA").equals("SENEPOL")) {
						cmbRaca.setSelectedIndex(4);

					} else if (rs.getString("RACA").equals("CHAROLES")) {
						cmbRaca.setSelectedIndex(5);

					} else if (rs.getString("RACA").equals("SINDI")) {
						cmbRaca.setSelectedIndex(6);

					} else {
						cmbRaca.setSelectedIndex(7);
					}
					
					editDataCompra.setText(rs.getString("DATACOMPRA"));
					editPrecoCompra.setText(rs.getString("PRECOCOMPRA"));
					editPrecoAtual.setText(rs.getString("PRECOATUAL"));
					
					if (rs.getString("STATUS").equals("ATIVO")) {
						cmbStatus.setSelectedIndex(0);

					} else if (rs.getString("STATUS").equals("VENDIDO")) {
						cmbRaca.setSelectedIndex(1);

					} else {
						cmbRaca.setSelectedIndex(2);
					}
					
					editPastagem.setText(rs.getString("PASTAGEM"));
					
					if (rs.getString("AFTOSA").equals("VACINOU")) {
						cmbAftosa.setSelectedIndex(0);

					} else {
						cmbAftosa.setSelectedIndex(1);
					}
					
					if (rs.getString("RAIVA").equals("VACINOU")) {
						cmbRaiva.setSelectedIndex(0);

					} else {
						cmbRaiva.setSelectedIndex(1);
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
			
			dataCompra    = new Date(editDataCompra.getText()).toString(Settings.DATE_DMY);

			lb = new LitebasePack();

			/*
			 * Primeiro deleto as informações dos animais
			 */

			sql = " DELETE FROM REBANHO " + " WHERE CODIGO = " + TabelaDeAnimais.codigoRebanho;

			lb.executeUpdate(sql);

			/*
			 * Depois insiro novamente com os dados atualizado
			 */

			sql = "INSERT INTO REBANHO " + "(" + " CODIGO, DESCRICAO, QUANTIDADE, IDADE, SEXO, RACA, PESO, DATACOMPRA,"
					+ " PRECOCOMPRA, " + " PRECOATUAL, " + " STATUS, " + " PASTAGEM, " + "AFTOSA, " + "RAIVA " + ")"
					+ " VALUES " + "( '" + TabelaDeAnimais.codigoRebanho + "', '" + editDescricao.getText() + "', '"
					+ editQuantidade.getText() + "', '" + editIdade.getText() + "', '"  + cmbSexo.getSelectedItem() 
					+ "', '" + cmbRaca.getSelectedItem() + "', '" + 0 + "'" + ", '"
					+ dataCompra + "'" + ", '" + editPrecoCompra.getText() + "'" + ", '" + editPrecoAtual.getText()
					+ "'" + ", '" + cmbStatus.getSelectedItem() + "', '" + editPastagem.getText() + "'" + ", '"
					+ cmbAftosa.getSelectedItem() + "'" + ", '" + cmbRaiva.getSelectedItem() + "'" + ")";

			lb.executeUpdate(sql);

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao cadastrarProdutoNoEstoque\n" + e);
			return;
		}

	}
}