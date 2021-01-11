package com.menu;

import com.auxiliares.Auxiliares;
import litebase.ResultSet;
import com.principal.Agil;
import com.tabelaDeAnimais.TabelaDeAnimais;
import com.vacinacao.Vacinacao;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;
import com.bottom.BottomImg;
import com.cadastroDeAnimais.CadastroDeAnimais;
import com.litebase.LitebasePack;
import com.loja.Loja;
import com.medicacao.Medicacao;
import com.movimentacaoCaixa.MovimentacaoCaixa;

public class Menu extends totalcross.ui.Window {
	
	private Button						 btnLoja;
	private Button 						 btnCadClientes;
	private Button						 btnCadFornecedor;
	private Button						 btnContasPagar;
	private Button						 btnCadAnimais;
	private Button						 btnPesagem;
	private Button						 btnMedicacao;
	private Button						 btnMovCaixa;
	private Button						 btnMovBanco;
	private Button						 btnChequesPre;
	private Button						 btnContReceber;
	private Button						 btnTabelaAnimais;
	private Button						 btnVacinacao;
	private Button						 btnLista;
	private Button						 btnManual;
	private Button						 btnFichaSalario;
	private Button						 btnReciboPagamento;
	private Button						 btnReciboRecebimento;
	private Button						 btnTelefone;
	private Button						 btnCalcJuros;
	
	private Button						 btnVoltar;	
	public ImageControl 		         imgMenu;
	
	private Edit						editNomeSistema;
	private Edit						editVersaoSistema;

	public Menu() {
		
		super("MENU", TAB_ONLY_BORDER);
		setBackColor(0x1c355d);
		initUI();

	}

	public void initUI() {

		try {

//----------Primeira Linha------------------------------------------------------------------------------------------------
			
			btnLoja = BottomImg.imageWithText(new Image("img/loja.png"), "LOJA", Button.BOTTOM);
			add(btnLoja, LEFT + 5, TOP + 60, SCREENSIZE + 14, SCREENSIZE + 15);
			btnLoja.setBackColor(0x1c355d);
			btnLoja.setForeColor(Color.WHITE);
			btnLoja.setFont(Auxiliares.getFontPequena());
			
			btnCadClientes = BottomImg.imageWithText(new Image("img/clientes.png"), "CLIENTES", Button.BOTTOM);
			add(btnCadClientes, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnCadClientes.setBackColor(0x1c355d);
			btnCadClientes.setForeColor(Color.WHITE);
			btnCadClientes.setFont(Auxiliares.getFontPequena());
			
			btnCadFornecedor = BottomImg.imageWithText(new Image("img/fornecedor.png"), "FORNECEDOR", Button.BOTTOM);
			add(btnCadFornecedor, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnCadFornecedor.setBackColor(0x1c355d);
			btnCadFornecedor.setForeColor(Color.WHITE);
			btnCadFornecedor.setFont(Auxiliares.getFontPequena());
			
			btnContasPagar = BottomImg.imageWithText(new Image("img/contas.png"), "CONTAS PAGAR", Button.BOTTOM);
			add(btnContasPagar, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnContasPagar.setBackColor(0x1c355d);
			btnContasPagar.setForeColor(Color.WHITE);
			btnContasPagar.setFont(Auxiliares.getFontPequena());
			
			btnCadAnimais = BottomImg.imageWithText(new Image("img/animais.png"), "CAD. ANIMAIS", Button.BOTTOM);
			add(btnCadAnimais, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnCadAnimais.setBackColor(0x1c355d);
			btnCadAnimais.setForeColor(Color.WHITE);
			btnCadAnimais.setFont(Auxiliares.getFontPequena());
			
			btnPesagem = BottomImg.imageWithText(new Image("img/pesagem.png"), "PESAGEM", Button.BOTTOM);
			add(btnPesagem, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnPesagem.setBackColor(0x1c355d);
			btnPesagem.setForeColor(Color.WHITE);
			btnPesagem.setFont(Auxiliares.getFontPequena());
			
			btnMedicacao = BottomImg.imageWithText(new Image("img/medicacao.png"), "MEDICAÇÃO", Button.BOTTOM);
			add(btnMedicacao, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnMedicacao.setBackColor(0x1c355d);
			btnMedicacao.setForeColor(Color.WHITE);
			btnMedicacao.setFont(Auxiliares.getFontPequena());
			
//----------Segunda Linha---------------------------------------------------------------------------------------------------
			
			btnMovCaixa = BottomImg.imageWithText(new Image("img/caixa.png"), "MOV. CAIXA", Button.BOTTOM);
			add(btnMovCaixa, LEFT + 5, AFTER + 30, SCREENSIZE + 14, SCREENSIZE + 15);
			btnMovCaixa.setBackColor(0x1c355d);
			btnMovCaixa.setForeColor(Color.WHITE);
			btnMovCaixa.setFont(Auxiliares.getFontPequena());
			
			btnMovBanco = BottomImg.imageWithText(new Image("img/banco.png"), "MOV. BANCO", Button.BOTTOM);
			add(btnMovBanco, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnMovBanco.setBackColor(0x1c355d);
			btnMovBanco.setForeColor(Color.WHITE);
			btnMovBanco.setFont(Auxiliares.getFontPequena());
			
			btnChequesPre = BottomImg.imageWithText(new Image("img/cheque.png"), "CHEQUES PRÉ", Button.BOTTOM);
			add(btnChequesPre, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnChequesPre.setBackColor(0x1c355d);
			btnChequesPre.setForeColor(Color.WHITE);
			btnChequesPre.setFont(Auxiliares.getFontPequena());
			
			btnContReceber = BottomImg.imageWithText(new Image("img/receber.png"), "CONT. RECEBER", Button.BOTTOM);
			add(btnContReceber, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnContReceber.setBackColor(0x1c355d);
			btnContReceber.setForeColor(Color.WHITE);
			btnContReceber.setFont(Auxiliares.getFontPequena());
			
			btnTabelaAnimais = BottomImg.imageWithText(new Image("img/tabAnimais.png"), "TABELA ANIMAIS", Button.BOTTOM);
			add(btnTabelaAnimais, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnTabelaAnimais.setBackColor(0x1c355d);
			btnTabelaAnimais.setForeColor(Color.WHITE);
			btnTabelaAnimais.setFont(Auxiliares.getFontPequena());
			
			btnVacinacao = BottomImg.imageWithText(new Image("img/vacinacao.png"), "VACINAÇÃO", Button.BOTTOM);
			add(btnVacinacao, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnVacinacao.setBackColor(0x1c355d);
			btnVacinacao.setForeColor(Color.WHITE);
			btnVacinacao.setFont(Auxiliares.getFontPequena());
			
			btnLista = BottomImg.imageWithText(new Image("img/lista.png"), "LISTAS", Button.BOTTOM);
			add(btnLista, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnLista.setBackColor(0x1c355d);
			btnLista.setForeColor(Color.WHITE);
			btnLista.setFont(Auxiliares.getFontPequena());

//----------Terceira Linha-------------------------------------------------------------------------------------------------------
			
			btnManual = BottomImg.imageWithText(new Image("img/manual.png"), "MANUAL / DICAS", Button.BOTTOM);
			add(btnManual, LEFT + 5, AFTER + 30, SCREENSIZE + 14, SCREENSIZE + 15);
			btnManual.setBackColor(0x1c355d);
			btnManual.setForeColor(Color.WHITE);
			btnManual.setFont(Auxiliares.getFontPequena());
			
			btnFichaSalario = BottomImg.imageWithText(new Image("img/salario.png"), "FICHA SALARIOS", Button.BOTTOM);
			add(btnFichaSalario, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnFichaSalario.setBackColor(0x1c355d);
			btnFichaSalario.setForeColor(Color.WHITE);
			btnFichaSalario.setFont(Auxiliares.getFontPequena());
			
			btnReciboPagamento = BottomImg.imageWithText(new Image("img/reciboPagamento.png"), "RECIBO PAGTO", Button.BOTTOM);
			add(btnReciboPagamento, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnReciboPagamento.setBackColor(0x1c355d);
			btnReciboPagamento.setForeColor(Color.WHITE);
			btnReciboPagamento.setFont(Auxiliares.getFontPequena());
			
			btnReciboRecebimento = BottomImg.imageWithText(new Image("img/reciboRecebimento.png"), "RECIBO RECEB.", Button.BOTTOM);
			add(btnReciboRecebimento, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnReciboRecebimento.setBackColor(0x1c355d);
			btnReciboRecebimento.setForeColor(Color.WHITE);
			btnReciboRecebimento.setFont(Auxiliares.getFontPequena());
			
			btnTelefone = BottomImg.imageWithText(new Image("img/telefone.png"), "TELEFONES", Button.BOTTOM);
			add(btnTelefone, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnTelefone.setBackColor(0x1c355d);
			btnTelefone.setForeColor(Color.WHITE);
			btnTelefone.setFont(Auxiliares.getFontPequena());
			
			btnCalcJuros = BottomImg.imageWithText(new Image("img/juros.png"), "CALC. DE JUROS", Button.BOTTOM);
			add(btnCalcJuros, AFTER, SAME, SCREENSIZE + 14, SCREENSIZE + 15);
			btnCalcJuros.setBackColor(0x1c355d);
			btnCalcJuros.setForeColor(Color.WHITE);
			btnCalcJuros.setFont(Auxiliares.getFontPequena());
			
//-------------------------------------------------------------------------------------------------------------------------------
			
			editVersaoSistema = new Edit();
			add(editVersaoSistema);
			editVersaoSistema.setEditable(false);
			editVersaoSistema.setRect(LEFT + 10, BOTTOM - 20, SCREENSIZE + 15, PREFERRED);
			editVersaoSistema.setBackColor(0x1c355d);
			editVersaoSistema.setForeColor(Color.BLACK);
			editVersaoSistema.setText("VERSÃO: " + Auxiliares.VERSAO);
			
			editNomeSistema = new Edit();
			add(editNomeSistema);
			editNomeSistema.setEditable(false);
			editNomeSistema.setRect(LEFT + 10, BEFORE + 2, SCREENSIZE + 15, PREFERRED, editVersaoSistema);
			editNomeSistema.setBackColor(0x1c355d);
			editNomeSistema.setForeColor(Color.BLACK);
			editNomeSistema.setText("NOME: " + Auxiliares.NOMESISTEMA);

			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
			
			
			reposition();
			
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao construir tela menu\n" + e);

		}

	}

	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnLoja) {
					
					Loja loja = new Loja();
					loja.popup();

				} else if (evt.target == btnCadClientes) {

				} else if (evt.target == btnCadFornecedor) {

				} else if (evt.target == btnContasPagar) {

				} else if (evt.target == btnCadAnimais) {
					
					CadastroDeAnimais cadasTroAnimais = new CadastroDeAnimais();
					cadasTroAnimais.popup();

				} else if (evt.target == btnPesagem) {

				} else if (evt.target == btnMedicacao) {
					
					Medicacao medicacao = new Medicacao();
					medicacao.popup();

				} else if (evt.target == btnMovCaixa) {
					
					MovimentacaoCaixa movimentacaoCaixa = new MovimentacaoCaixa();
					movimentacaoCaixa.popup();

				} else if (evt.target == btnMovBanco) {

				} else if (evt.target == btnChequesPre) {

				} else if (evt.target == btnContReceber) {

				} else if (evt.target == btnTabelaAnimais) {
					
					TabelaDeAnimais tabelaDeAnimais = new TabelaDeAnimais();
					tabelaDeAnimais.popup();

				} else if (evt.target == btnVacinacao) {
					
					Vacinacao vacinacao = new Vacinacao();
					vacinacao.popup();

				} else if (evt.target == btnLista) {

				} else if (evt.target == btnManual) {

				} else if (evt.target == btnFichaSalario) {

				} else if (evt.target == btnReciboPagamento) {

				} else if (evt.target == btnReciboRecebimento) {

				} else if (evt.target == btnTelefone) {

				} else if (evt.target == btnCalcJuros) {

				} else if (evt.target == btnVoltar) {
					unpop();
				}

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação do menu\n" + e);
		}

	}

}
