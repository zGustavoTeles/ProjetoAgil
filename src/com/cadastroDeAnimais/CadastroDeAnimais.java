package com.cadastroDeAnimais;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Random;

public class CadastroDeAnimais extends totalcross.ui.Window{
	
    private Button							btnCadastrar;
    private Button							btnDeletar;
    private Button							btnVoltar;
    
    public Label 							lblDescricao;
    public Label 							lblIdadeMeses;
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
    public Label 							lblSetor;
    
    public Edit 							editDescricao;
    public Edit								editPrecoCompra;
    public Edit								editPrecoAtual;
    public Edit								editDataCompra;
    
    public ComboBox							cmbIdadeMeses;
    public ComboBox							cmbSexo;
    public ComboBox							cmbRaca;
    public ComboBox							cmbPeso;
    public ComboBox							cmbDataCompra;
    public ComboBox							cmbStatus;
    public ComboBox							cmbSetor;
    

	
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
			editDescricao.setValidChars("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ");
			
			lblIdadeMeses = new Label("IDADE/MESES:");
			add(lblIdadeMeses);
			lblIdadeMeses.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblIdadeMeses.setForeColor(Color.WHITE);
			lblIdadeMeses.setFont(Auxiliares.getFontBold());
			
			cmbIdadeMeses = new ComboBox();			
			add(cmbIdadeMeses);
			cmbIdadeMeses.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblIdadeMeses);
			
			lblSexo = new Label("SEXO:");
			add(lblSexo);
			lblSexo.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblSexo.setForeColor(Color.WHITE);
			lblSexo.setFont(Auxiliares.getFontBold());
			
			cmbSexo = new ComboBox();			
			add(cmbSexo);
			cmbSexo.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblIdadeMeses);
			
			lblRaca = new Label("RAÇA:");
			add(lblRaca);
			lblRaca.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblRaca.setForeColor(Color.WHITE);
			lblRaca.setFont(Auxiliares.getFontBold());
			
			cmbRaca = new ComboBox();			
			add(cmbRaca);
			cmbRaca.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblRaca);
			
			lblPeso = new Label("PRESO (KGS):");
			add(lblPeso);
			lblPeso.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblPeso.setForeColor(Color.WHITE);
			lblPeso.setFont(Auxiliares.getFontBold());
			
			cmbPeso = new ComboBox();			
			add(cmbPeso);
			cmbPeso.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblPeso);
			
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
			
			lblSetor = new Label("SETOR:");
			add(lblSetor);
			lblSetor.setRect(LEFT + 180, AFTER + 10, PREFERRED, PREFERRED);
			lblSetor.setForeColor(Color.WHITE);
			lblSetor.setFont(Auxiliares.getFontBold());
			
			cmbSetor = new ComboBox();			
			add(cmbSetor);
			cmbSetor.setRect(CENTER + 100, SAME, SCREENSIZE + 40, SCREENSIZE + 4, lblSetor);

			btnCadastrar = BottomImg.imageWithText(new Image("img/cadastrar.png"), "Cadastrar", Button.BOTTOM);
			add(btnCadastrar, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnCadastrar.setBackColor(0x1c355d);
			btnCadastrar.setForeColor(Color.WHITE);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
            btnVoltar.setForeColor(Color.WHITE);

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

				} else if (evt.target == btnDeletar) {
//					Usuarios usuarios = new Usuarios();
//					usuarios.popup();
				}

			}
		} catch (Exception e) {
			/*
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela carrinho\n" + e);
			*/
		}

	}
}