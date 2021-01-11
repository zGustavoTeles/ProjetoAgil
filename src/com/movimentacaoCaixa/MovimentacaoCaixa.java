package com.movimentacaoCaixa;

import com.agenda.Agenda;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.email.Email;
import com.litebase.LitebasePack;
import com.pdf.Pdf;
import com.principal.Agil;

import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;
import totalcross.sys.Settings;

public class MovimentacaoCaixa extends totalcross.ui.Window{
	
	private Label							lblData;
	private Label							lblA;
	private Edit							editQuantidade;
	private Edit							editTotal;
	private Edit							editDataUm;
	private Edit							editDataDois;
	private Grid							gridVendas;
	private Button 						    btnVoltar;
	private Button						    btnBuscar;
	private Button						    btnDetalhar;
	private Button						    btnPdf;
	private Button						    btnEmail;
	
	public String							dataI;
	public String							dataII;
	
	public static String					codigoVenda = "";
	public static String					codigoAnimal = "";
	
	public MovimentacaoCaixa(){
		 super("MOVIMENTACÃO DO CAIXA", TAB_ONLY_BORDER);
		 setBackColor(0x1c355d);
		 initUI();
	}
	
	public void initUI() {
		
		try {

			lblData = new Label("DATA: ");
			add(lblData);
			lblData.setRect(LEFT, TOP + 10, PREFERRED, PREFERRED);
			lblData.setBackColor(0x1c355d);
			lblData.setForeColor(Color.WHITE);

			editDataUm = new Edit();
			add(editDataUm);
			editDataUm.setRect(AFTER + 2, SAME, SCREENSIZE + 35, PREFERRED, lblData);
			editDataUm.setBackColor(Color.WHITE);
			editDataUm.setForeColor(0x1c355d);

			lblA = new Label(" Á ");
			add(lblA);
			lblA.setRect(AFTER + 2, SAME, PREFERRED, PREFERRED, editDataUm);
			lblA.setBackColor(0x1c355d);
			lblA.setForeColor(Color.WHITE);

			editDataDois = new Edit();
			add(editDataDois);
			editDataDois.setRect(AFTER + 2, SAME, SCREENSIZE + 35, PREFERRED, lblA);
			editDataDois.setBackColor(Color.WHITE);
			editDataDois.setForeColor(0x1c355d);

			btnBuscar = new Button("BUSCAR");
			add(btnBuscar);
			btnBuscar.setRect(AFTER + 10, SAME, SCREENSIZE + 18, PREFERRED + 5, editDataDois);
			btnBuscar.setBackColor(0x1c355d);
			btnBuscar.setForeColor(Color.WHITE);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar,RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
			
			btnDetalhar = BottomImg.imageWithText(new Image("img/pesquisar.png"), "Detalhar", Button.BOTTOM);
			add(btnDetalhar, LEFT, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnDetalhar.setBackColor(0x1c355d);
			btnDetalhar.setForeColor(Color.WHITE);

			btnPdf = BottomImg.imageWithText(new Image("img/pdf.png"), "Gerar PDF", Button.BOTTOM);
			add(btnPdf, AFTER + 8, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnPdf.setBackColor(0x1c355d);
			btnPdf.setForeColor(Color.WHITE);

			btnEmail = BottomImg.imageWithText(new Image("img/email.png"), "Enviar E-mail", Button.BOTTOM);
			add(btnEmail, AFTER + 8, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnEmail.setBackColor(0x1c355d);
			btnEmail.setForeColor(Color.WHITE);

			editQuantidade = new Edit();
			add(editQuantidade);
			editQuantidade.setEditable(false);
			editQuantidade.setRect(LEFT + 2, BEFORE - 40, SCREENSIZE - 2, PREFERRED, btnDetalhar);
			editQuantidade.setBackColor(0x1c355d);
			editQuantidade.setForeColor(Color.BLACK);
			editQuantidade.setText("QUANTIDADE:");

			editTotal = new Edit();
			add(editTotal);
			editTotal.setEditable(false);
			editTotal.setRect(RIGHT - 5, BEFORE - 40, SCREENSIZE - 2, PREFERRED, btnVoltar);
			editTotal.setBackColor(0x1c355d);
			editTotal.setForeColor(Color.BLACK);
			editTotal.setText("TOTAL: R$");

			int gridWidths[] = new int[18];
			
			gridWidths[0]  = 5;
			gridWidths[1]  = 200;
			gridWidths[2]  = 200;
			gridWidths[3]  = 200;
			gridWidths[4]  = 100;
			gridWidths[5]  = 200;
			gridWidths[6]  = 50;
			gridWidths[7]  = 300;
			gridWidths[8]  = 100;
			gridWidths[9]  = 100;
			gridWidths[10] = 100;
			gridWidths[11] = 200;
			gridWidths[12] = 200;
			gridWidths[13] = 200;
			gridWidths[14] = 200;
			gridWidths[15] = 200;
			gridWidths[16] = 200;
			gridWidths[17] = 200;

			String[] caps = { "CÓDIGO VENDA", "CÓDIGO ANIMAL", "DESCRIÇÃO", "IDADE", "SEXO", "RAÇA", "PESO", "DATA COMPRA",
					"PREÇO COMPRA", "PREÇO VENDA", "STATUS", "PASTAGEM", "AFTOSA", "RAIVA", "QUANTIDADE VENDIDA", "DATA DA VENDA", "TIPO PAGAMENTO", "TOTAL" };
			
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT,
					Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT };
			
			gridVendas = new Grid(caps, gridWidths, aligns, false);
			add(gridVendas);
			gridVendas.enableColumnResize = true;
			gridVendas.secondStripeColor = Color.getRGB(255, 255, 255);
			gridVendas.setBackColor(Auxiliares.backColorGridNovo);
			gridVendas.setForeColor(Auxiliares.defaultForeColorGridNovo);
			gridVendas.transparentBackground = false;
			gridVendas.setBorderStyle(totalcross.ui.Container.BORDER_NONE);
			gridVendas.verticalLineStyle = totalcross.ui.Grid.VERT_LINE;
			gridVendas.drawCheckBox = true;
			gridVendas.disableSort = false;
			gridVendas.boldCheck = false;
			gridVendas.captionsBackColor = Auxiliares.captionsBackColorNovo;
			gridVendas.checkColor = Auxiliares.checkColorNovo;
			gridVendas.firstStripeColor = Auxiliares.firstStripeColorNovo;
			gridVendas.enableColumnResize = false;
			gridVendas.setFont(Auxiliares.getFontNormal().asBold());
			gridVendas.secondStripeColor = Auxiliares.secondStripeColorNovo;
			gridVendas.setCellController(new CellController6());
			gridVendas.setRect(Grid.CENTER + 1, BEFORE - 10, SCREENSIZE + 100, SCREENSIZE + 66, editQuantidade);

			reposition();

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO","Erro ao construir a tela MovimentacaoCaixa\n" + e);

		}
		
	}

	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnBuscar) {
					if (editDataUm.getText().equals("") || editDataDois.getText().equals("")) {

						Auxiliares.messagebox("AGIL", "Preencha todos os campos de data à serem pesquisados!");
						return;

					} else {
						pesquisaVendasPorPeriodo();
					}
				} else if (evt.target == btnDetalhar) {
					
					if (gridVendas.getSelectedItem() != null) {
						
						DetalharVenda detalharVenda = new DetalharVenda();
						detalharVenda.popup();
						
					} else {
						
						Auxiliares.messagebox("AGIL", "Deve-se selecionar uma venda!");
						return;

					}
				} else if (evt.target == btnPdf) {

					if (editDataUm.getText().equals("") || editDataDois.getText().equals("")) {

						Auxiliares.messagebox("AGIL",
								"Preencha todos os campos de data à serem pesquisados, e realize uma pesquisa para gerar um relatório em PDF");
						return;

					} else {

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja gerar um relatório das vendas pesquisas em PDF?",
								ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							dataI = new Date(editDataUm.getText()).toString(Settings.DATE_YMD);
							dataII = new Date(editDataDois.getText()).toString(Settings.DATE_YMD);

							Pdf pdf = new Pdf();

							pdf.gerarPDFDeVenda(dataI, dataII);
						}
					}
				} else if (evt.target == btnEmail) {

					if (editDataUm.getText().equals("") || editDataDois.getText().equals("")) {
						
						Auxiliares.messagebox("AGIL",
								"Preencha todos os campos de data à serem pesquisados, e realize uma pesquisa para gerar um relatório há ser enviado por e-mail");
						return;

					} else {
						
						String emailEnvio = "";
						
						emailEnvio = Auxiliares.messageInput("AGIL", "Por favor insira um endereço de e-mail", "");
						
						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja enviar um relatório das vendas pesquisas por e-mail?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {
							
							dataI 		= new Date(editDataUm.getText()).toString(Settings.DATE_YMD);
							dataII 		= new Date(editDataDois.getText()).toString(Settings.DATE_YMD);

							Email email = new Email();
							email.enviaEmailVendasPeriodo(dataI, dataII, emailEnvio);
						}
					}
				}

				break;
			case PenEvent.PEN_DOWN:

				if (evt.target == editDataUm) {
					Agenda.setDateByCalendarBox(editDataUm);

				} else if (evt.target == editDataDois) {
					Agenda.setDateByCalendarBox(editDataDois);
				}
				break;
			case GridEvent.SELECTED_EVENT:
				if (evt.target == gridVendas) {

					try {

						codigoVenda 			 = gridVendas.getSelectedItem()[0];
						codigoAnimal			 = gridVendas.getSelectedItem()[1];

					} catch (Exception e) {
						Auxiliares.messagebox("AGIL", "Clique em uma venda!");
					}

				}

			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela MovimentacaoCaixa\n" + e);
		}

	}
	
	public void pesquisaVendasPorPeriodo() throws Exception {
		
		String sql		   = "";
		LitebasePack lb    = null;
		ResultSet rs	   = null;
		int quantidade     = 0;
		double total	   = 0;

		try {
			
			try {
				
				gridVendas.removeAllElements();
				
				dataI    = new Date(editDataUm.getText()).toString(Settings.DATE_YMD);
				dataII   = new Date(editDataDois.getText()).toString(Settings.DATE_YMD);
				
				lb = new LitebasePack();
				
				sql = " SELECT * FROM VENDAANIMAL "
					+ " WHERE DATAVENDA >= " + "'" + dataI + "'"
					+ " AND DATAVENDA<= " + "'" + dataII + "'";

				rs = lb.executeQuery(sql);
				rs.first();
				
				for (int i = 0; rs.getRowCount() > i; i++) {
					
					String[] b = new String[18];
					
					b[0]  = Convert.toString(rs.getInt("CODIGOVENDA"));
					b[1]  = Convert.toString(rs.getInt("CODIGOANIMAL"));
					b[2]  = rs.getString("DESCRICAO");
					b[3]  = rs.getString("IDADE");
					b[4]  = rs.getString("SEXO");
					b[5]  = rs.getString("RACA");
					b[6]  = rs.getString("PESO");
					b[7]  = rs.getString("DATACOMPRA");
					b[8]  = rs.getString("PRECOCOMPRA");
					b[9]  = rs.getString("PRECOVENDA");
					b[10] = rs.getString("STATUS");
					b[11] = rs.getString("PASTAGEM");
					b[12] = rs.getString("AFTOSA");
					b[13] = rs.getString("RAIVA");
					b[14] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[15] = rs.getString("DATAVENDA");
					b[16] = rs.getString("TIPOPAGAMENTO");
					b[17] = rs.getString("TOTALVENDA");
					
					gridVendas.add(b);
					
					quantidade += rs.getInt("QUANTIDADE");
					total      += Convert.toDouble(rs.getString("TOTALVENDA"));
					
					rs.next();
				}
				
				editQuantidade.setText("QUANTIDADE: " + Convert.toString(quantidade));
				editTotal.setText( "TOTAL: R$" + Convert.toCurrencyString(total, 2).replace(",", "."));
				
			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao pesquisaVendasPorPeriodo\n" + e);

		}

	}	
	
}
