package com.cadastroDeAnimais;

import com.agenda.Agenda;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import com.sun.org.apache.bcel.internal.generic.IDIV;

import litebase.ResultSet;
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
    public Label 							lblPrecoAtual;
    public Label 							lblVendaPerda;
//    public Label 							lblMesesAtual;
//    public Label 							lblCategoriaMeses;
    public Label 							lblStatus;
    public Label 							lblPastagem;
    
    public Edit 							editDescricao;
    public Edit								editPrecoCompra;
    public Edit								editPrecoAtual;
    public Edit								editDataCompra;
    public Edit								editPastagem;
    public Edit								editIdade;
    
    public ComboBox							cmbSexo;
    public ComboBox							cmbRaca;
    public ComboBox							cmbPeso;
    public ComboBox							cmbDataCompra;
    public ComboBox							cmbStatus;
    

	
	public CadastroDeAnimais(){ 
		super("CADASTRO DE ANIMAIS", TAB_ONLY_BORDER);
		 setBackColor(0x1c355d);
		 initUI();
		 
	}
	
	public void initUI() {
		
		try {
			
			lblDescricao = new Label("DESCRIÇÃO:");
			add(lblDescricao);
			lblDescricao.setRect(LEFT + 180, TOP + 100, PREFERRED, PREFERRED);
			lblDescricao.setForeColor(Color.WHITE);
			lblDescricao.setFont(Auxiliares.getFontBold());
			
			editDescricao = new Edit();			
			add(editDescricao);
			editDescricao.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblDescricao);
			editDescricao.setBackColor(Color.WHITE);
			editDescricao.setForeColor(0x1c355d);
			
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
			
			lblSexo = new Label("SEXO:");
			add(lblSexo);
			lblSexo.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblSexo.setForeColor(Color.WHITE);
			lblSexo.setFont(Auxiliares.getFontBold());
			
			cmbSexo = new ComboBox();			
			add(cmbSexo);
			cmbSexo.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblSexo);
			
			lblRaca = new Label("RAÇA:");
			add(lblRaca);
			lblRaca.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblRaca.setForeColor(Color.WHITE);
			lblRaca.setFont(Auxiliares.getFontBold());
			
			cmbRaca = new ComboBox();			
			add(cmbRaca);
			cmbRaca.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblRaca);
			
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
			
			lblStatus = new Label("STATUS:");
			add(lblStatus);
			lblStatus.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblStatus.setForeColor(Color.WHITE);
			lblStatus.setFont(Auxiliares.getFontBold());
			
			cmbStatus = new ComboBox();			
			add(cmbStatus);
			cmbStatus.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblStatus);
			
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

			btnCadastrar = BottomImg.imageWithText(new Image("img/cadastrar.png"), "Cadastrar", Button.BOTTOM);
			add(btnCadastrar, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnCadastrar.setBackColor(0x1c355d);
			btnCadastrar.setForeColor(Color.WHITE);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
            btnVoltar.setForeColor(Color.WHITE);

			carregaCmbSexo();
			carregaCmbRaca();
			carregaCmbStatus();

			reposition();
			
		} catch (Exception e) {

			Auxiliares.messagebox("Erro", "construir a tela CadastrarUsuario");
		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnCadastrar) {

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
	
	public void cadastraAnimal() {
		String sql = "";
		LitebasePack lb = null;

		try {
			Random random = new Random();
			int codigo = random.nextInt(900);

			lb = new LitebasePack();

			sql = "INSERT INTO REBANHO " + "(" + " CODIGO, DESCRICAO, IDADE, SEXO, RACA, PESO, DATACOMPRA,"
					+ " PRECOCOMPRA, " + " PRECOATUAL, " + " STATUS, " + " PASTAGEM " + ")" + " VALUES " + "( '"
					+ codigo + "', '" + editDescricao.getText() + "', '" + editIdade.getText() + "', '"
					+ cmbSexo.getSelectedItem() + "', '" + cmbRaca.getSelectedItem() + "', '" + 0 + "'" + "', '"
					+ editDataCompra.getText() + "'" + "', '" + editPrecoCompra.getText() + "'" + "', '"
					+ editPrecoAtual.getText() + "'" + "', '" + cmbStatus.getSelectedItem() + "', '"
					+ editPastagem.getText() + ")";

			lb.executeUpdate(sql);


		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao cadastrarProdutoNoEstoque\n" + e);
			return;
		}

	}
}