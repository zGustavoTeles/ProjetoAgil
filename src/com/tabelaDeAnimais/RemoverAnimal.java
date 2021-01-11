package com.tabelaDeAnimais;

import com.agenda.Agenda;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class RemoverAnimal extends totalcross.ui.Window{
	
    private Button							btnRemover;
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
    public Label 							lblRebanho;
    
    public Edit 							editDescricao;
    public Edit								editPrecoCompra;
    public Edit								editPrecoVenda;
    public Edit								editDataCompra;
    public Edit								editPastagem;
    public Edit								editIdade;
    public Edit								editQuantidade;
    public Edit								editRebanho;
    
    public ComboBox							cmbSexo;
    public ComboBox							cmbRaca;
    public ComboBox							cmbPeso;
    public ComboBox							cmbDataCompra;
    public ComboBox							cmbStatus;
    
    public ComboBox							cmbAftosa;
    public ComboBox							cmbRaiva;
    

	
	public RemoverAnimal(){ 
		super("REMOVER ANIMAL (S)", TAB_ONLY_BORDER);
		 setBackColor(0x1c355d);
		 initUI();
		 carregaInfoAnimal();
	}
	
	public void initUI() {
		
		try {
			
			lblDescricao = new Label("DESCRIÇÃO:");
			add(lblDescricao);
			lblDescricao.setRect(LEFT + 180, TOP + 80, PREFERRED, PREFERRED);
			lblDescricao.setForeColor(Color.WHITE);
			lblDescricao.setFont(Auxiliares.getFontBold());
			
			editDescricao = new Edit();			
			add(editDescricao);
			editDescricao.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblDescricao);
			editDescricao.setBackColor(Color.WHITE);
			editDescricao.setForeColor(0x1c355d);
			editDescricao.capitalise = (Edit.ALL_UPPER); 
			editDescricao.setEnabled(false);
			
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
			editIdade.setEnabled(false);
			
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
			editDataCompra.setEnabled(false);
			
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
			editPrecoCompra.setValidChars("0123456789.");
			editPrecoCompra.setEnabled(false);
			
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
			editPrecoVenda.setValidChars("0123456789.");
			editPrecoVenda.setEnabled(false);
			
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
			editPastagem.setEnabled(false);

			lblRebanho = new Label("REBANHO:");
			add(lblRebanho);
			lblRebanho.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblRebanho.setForeColor(Color.WHITE);
			lblRebanho.setFont(Auxiliares.getFontBold());
			
			editRebanho = new Edit();			
			add(editRebanho);
			editRebanho.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblRebanho);
			editRebanho.setBackColor(Color.WHITE);
			editRebanho.setForeColor(0x1c355d);
			editRebanho.setValidChars("0123456789");
			editRebanho.setEnabled(false);
			
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

			btnRemover = BottomImg.imageWithText(new Image("img/remover.png"), "Remover", Button.BOTTOM);
			add(btnRemover, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnRemover.setBackColor(0x1c355d);
			btnRemover.setForeColor(Color.WHITE);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
            btnVoltar.setForeColor(Color.WHITE);

			reposition();
			editQuantidade.requestFocus();
			
		} catch (Exception e) {

			Auxiliares.messagebox("Erro", "construir a tela RemoverAnimal\n" + e );
		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnRemover) {

					if (editQuantidade.getText().equals("")) {
						Auxiliares.messagebox("AGIL", "Por favor digite uma quantidade!");

						return;

					} else if (Convert.toInt(editQuantidade.getText()) == 0) {
						Auxiliares.messagebox("AGIL", "Quantidade inválida!");
						editQuantidade.setText("");

						return;

					} else if (Convert.toInt(editQuantidade.getText()) > Convert
							.toInt(TabelaDeAnimais.quantidadeRebanho)) {
						Auxiliares.messagebox("AGIL", "Quantidade inserida maior que a quantidade do rebanho!");

						editQuantidade.setText("");

						return;

					} else {

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja remover " +editQuantidade.getText() + " quantidade(s) desse animal\n"
								+ "do rebanho?",
								ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							removeAnimalRebanho();

							Auxiliares.messagebox("AGIL", ""+ editQuantidade.getText() + " quantidade(s) desse animal(s) removido(s) com sucesso!");

							editDescricao.setText("");
							editQuantidade.setText("");
							editIdade.setText("");
							editDataCompra.setText("");
							editPrecoCompra.setText("");
							editPrecoVenda.setText("");
							editPastagem.setText("");

							TabelaDeAnimais.buscaAnimaisCadastrados();

							unpop();
						}
					}

				} else if (evt.target == btnVoltar) {
					unpop();

				}
				
				if (editQuantidade.getText().length() == 0) {
					editRebanho.setText(TabelaDeAnimais.quantidadeRebanho);
				}

				if (editQuantidade.getText().length() > 0) {
					editRebanho.setText("");
					editRebanho.setText(TabelaDeAnimais.quantidadeRebanho);
					calculaQuantidadeRebanho();

				}

			case PenEvent.PEN_DOWN:

				if (evt.target == editDataCompra) {
					Agenda.setDateByCalendarBox(editDataCompra);

				}

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro onEvent tela RemoverAnimal\n" + e);
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
					editIdade.setText(rs.getString("IDADE"));
					editDataCompra.setText(rs.getString("DATACOMPRA"));
					editPrecoCompra.setText(rs.getString("PRECOCOMPRA"));
					editPrecoVenda.setText(rs.getString("PRECOVENDA"));
					editPastagem.setText(rs.getString("PASTAGEM"));
					editRebanho.setText(Convert.toString(rs.getInt("QUANTIDADE")));
					
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbAlternativa\n" + e);

			}

		}
	}
	
	public void calculaQuantidadeRebanho() {

		try {

			int total 	= 0;
			total 		= Convert.toInt(editRebanho.getText()) - Convert.toInt(editQuantidade.getText());
			editRebanho.setText(Convert.toString(total));

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao calcularQuantidade\n" + e);
		}

	}
	
	public void removeAnimalRebanho() {

		String sql 				= "";
		LitebasePack lb 		= null;
		
		try {

			try {

				lb = new LitebasePack();
				sql = " UPDATE REBANHO " 
				    + " SET QUANTIDADE = " + editRebanho.getText() 
					+ " WHERE CODIGO = "   + TabelaDeAnimais.codigoRebanho;

				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro a removeAnimalRebanho\n" + e);
			return;
		}
	}
	
}