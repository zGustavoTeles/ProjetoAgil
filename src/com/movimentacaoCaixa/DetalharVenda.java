package com.movimentacaoCaixa;

import java.util.Random;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class DetalharVenda extends totalcross.ui.Window {

	private Edit				 editDescricao;
	private Edit				 editIdade;
	private Edit				 editSexo;
	private Edit				 editRaca;
	private Edit 				 editDataCompra;
	private Edit				 editPeso;
	private Edit 				 editPrecoVenda;
	private Edit				 editPrecoCompra;
	private Edit 				 editStatus;
	private Edit 				 editPastagem;
	private Edit 				 editAftosa;
	private Edit 				 editRaiva;
	private Edit 				 editQuantidadeVendida;
	private Edit 				 editDataVenda;
	private Edit 				 editTipoPagamento;
	private Edit 				 editTotal;
	
	private Button 				 btnVoltar;
	
	private ImageControl		 imgDetalharVenda;
	
	public int	 						 	codigoVendaInfo = 0;
	public int	 				 			codigoAnimalInfo = 0;
	public String 				 			descricaoInfo = "";
	public String	 			 			idadeInfo = "";
	public String 				 			sexoInfo = "";
	public String 				 			racaInfo = "";
	public String 				 			pesoInfo = "";
	public String 				 			dataDaCompraInfo = "";
	public String 				 			precocompraInfo = "";
	public String 				 			precoVendaInfo = "";
	public String 				 			statusInfo = "";
	public String 				 			pastagemInfo = "";
	public String 				 			aftosaInfo = "";
	public String 				 			raivaInfo = "";
	public int	 				 			quantidadeVendidaInfo = 0;
	public Date 				 			dataVendaInfo;
	public String 				 			tipopagamentoInfo = "";
	public String 				 			totalInfo = "";
	public double 				 			totalInfoCalc = 0.00;
	
	public int								qntDeAnimaisVendidos = 0;
	public double							valorTotalDevendas = 0.00;

	public DetalharVenda() {
		super("DETALHAR VENDA", TAB_ONLY_BORDER);
		setBackColor(0x1c355d);
		initUI();
	}

	public void initUI() {

		try {
			
			carregaInfoAnimal();
			
			imgDetalharVenda = new ImageControl(new Image("img/detalharVenda.png"));
			imgDetalharVenda.scaleToFit = true;
			imgDetalharVenda.centerImage = true;
			add(imgDetalharVenda, LEFT + 10, TOP + 50, SCREENSIZE + 35, SCREENSIZE + 55);

			editDescricao = new Edit();
			add(editDescricao);
			editDescricao.setRect(CENTER + 190, TOP + 50, SCREENSIZE + 50, SCREENSIZE + 4, imgDetalharVenda);
			editDescricao.setBackColor(Color.WHITE);
			editDescricao.setForeColor(0x1c355d);
			editDescricao.setText("DESCRICÃO: " + descricaoInfo);
			editDescricao.setEditable(false);

			editIdade = new Edit();
			add(editIdade);
			editIdade.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editDescricao);
			editIdade.setBackColor(Color.WHITE);
			editIdade.setForeColor(0x1c355d);
			editIdade.setText("IDADE: " + idadeInfo);
			editIdade.setEditable(false);	

			editSexo = new Edit();
			add(editSexo);
			editSexo.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editIdade);
			editSexo.setBackColor(Color.WHITE);
			editSexo.setForeColor(0x1c355d);
			editSexo.setText("SEXO: " + sexoInfo);
			editSexo.setEditable(false);

			editRaca = new Edit();
			add(editRaca);
			editRaca.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editSexo);
			editRaca.setBackColor(Color.WHITE);
			editRaca.setForeColor(0x1c355d);
			editRaca.setText("RAÇA: " + racaInfo);
			editRaca.setEditable(false);

			editPeso = new Edit();
			add(editPeso);
			editPeso.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editRaca);
			editPeso.setBackColor(Color.WHITE);
			editPeso.setForeColor(0x1c355d);
			editPeso.setText("PESO: " + pesoInfo.toString());
			editPeso.setEditable(false);
			
			editDataCompra = new Edit();
			add(editDataCompra);
			editDataCompra.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editPeso);
			editDataCompra.setBackColor(Color.WHITE);
			editDataCompra.setForeColor(0x1c355d);
			editDataCompra.setText("DATA DA COMPRA: " + dataDaCompraInfo.toString());
			editDataCompra.setEditable(false);

			editPrecoCompra = new Edit();
			add(editPrecoCompra);
			editPrecoCompra.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editDataCompra);
			editPrecoCompra.setBackColor(Color.WHITE);
			editPrecoCompra.setForeColor(0x1c355d);
			editPrecoCompra.setText("PREÇO DE COMPRA: " + precocompraInfo);
			editPrecoCompra.setEditable(false);

			editPrecoVenda = new Edit();
			add(editPrecoVenda);
			editPrecoVenda.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editPrecoCompra);
			editPrecoVenda.setBackColor(Color.WHITE);
			editPrecoVenda.setForeColor(0x1c355d);
			editPrecoVenda.setText("PREÇO DE VENDA: " + precoVendaInfo);
			editPrecoVenda.setEditable(false);

			editStatus = new Edit();
			add(editStatus);
			editStatus.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editPrecoVenda);
			editStatus.setBackColor(Color.WHITE);
			editStatus.setForeColor(0x1c355d);
			editStatus.setText("STATUS: " + statusInfo);
			editStatus.setEditable(false);
			
			editPastagem = new Edit();
			add(editPastagem);
			editPastagem.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editStatus);
			editPastagem.setBackColor(Color.WHITE);
			editPastagem.setForeColor(0x1c355d);
			editPastagem.setText("PASTAGEM: " +pastagemInfo);
			editPastagem.setEditable(false);
			
			editAftosa = new Edit();
			add(editAftosa);
			editAftosa.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editPastagem);
			editAftosa.setBackColor(Color.WHITE);
			editAftosa.setForeColor(0x1c355d);
			editAftosa.setText("AFTOSA: " +aftosaInfo);
			editAftosa.setEditable(false);
			
			editRaiva = new Edit();
			add(editRaiva);
			editRaiva.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editAftosa);
			editRaiva.setBackColor(Color.WHITE);
			editRaiva.setForeColor(0x1c355d);
			editRaiva.setText("RAIVA: " + raivaInfo);
			editRaiva.setEditable(false);
			
			editQuantidadeVendida = new Edit();
			add(editQuantidadeVendida);
			editQuantidadeVendida.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editRaiva);
			editQuantidadeVendida.setBackColor(Color.WHITE);
			editQuantidadeVendida.setForeColor(0x1c355d);
			editQuantidadeVendida.setText("QUANTIDADE VENDIDA: " + Convert.toString(quantidadeVendidaInfo));
			editQuantidadeVendida.setEditable(false);
			
			editDataVenda = new Edit();
			add(editDataVenda);
			editDataVenda.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editQuantidadeVendida);
			editDataVenda.setBackColor(Color.WHITE);
			editDataVenda.setForeColor(0x1c355d);
			editDataVenda.setText("DATA DA VENDA: " + dataVendaInfo.toString());
			editDataVenda.setEditable(false);
			
			editTipoPagamento = new Edit();
			add(editTipoPagamento);
			editTipoPagamento.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editDataVenda);
			editTipoPagamento.setBackColor(Color.WHITE);
			editTipoPagamento.setForeColor(0x1c355d);
			editTipoPagamento.setText("TIPO DE PAGAMENTO: " +tipopagamentoInfo);
			editTipoPagamento.setEditable(false);
			
			editTotal = new Edit();
			add(editTotal);
			editTotal.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 4, editTipoPagamento);
			editTotal.setBackColor(Color.WHITE);
			editTotal.setForeColor(0x1c355d);
			editTotal.setText("TOTAL DA VENDA: " + totalInfo);
			editTotal.setEditable(false);
			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO","Erro ao construir a tela DetalharVenda\n" + e);

		}

	}

	public void onEvent(Event evt) {

		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				}
				
			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela inserir\n" + e);
		}

	}

	public void carregaInfoAnimal() {
		{
			String sql 				= "";
			LitebasePack lb 		= null;
			ResultSet rs 			= null;

			try {
				try {

					lb = new LitebasePack();
					
					sql = " SELECT * FROM VENDAANIMAL "
					    + " WHERE CODIGOANIMAL = " + MovimentacaoCaixa.codigoAnimal
						+ " AND CODIGOVENDA = " +  MovimentacaoCaixa.codigoVenda;
								
								
						 rs = lb.executeQuery(sql);
						 rs.beforeFirst();
								

					 while (rs.next()) {
									
					  codigoVendaInfo 					= rs.getInt("CODIGOVENDA");
					  codigoAnimalInfo 					= rs.getInt("CODIGOANIMAL");
					  descricaoInfo 					= rs.getString("DESCRICAO");
					  idadeInfo 						= rs.getString("IDADE");
					  sexoInfo 							= rs.getString("SEXO");
					  racaInfo 							= rs.getString("RACA");
					  pesoInfo 							= rs.getString("PESO");
					  dataDaCompraInfo 					= rs.getString("DATACOMPRA");
					  precocompraInfo 					= rs.getString("PRECOCOMPRA");
					  precoVendaInfo 					= rs.getString("PRECOVENDA");
					  statusInfo 						= rs.getString("STATUS");
					  pastagemInfo 						= rs.getString("PASTAGEM");
					  aftosaInfo 						= rs.getString("AFTOSA");
					  raivaInfo 						= rs.getString("RAIVA");
					  quantidadeVendidaInfo				= rs.getInt("QUANTIDADE");
					  dataVendaInfo 					= rs.getDate("DATAVENDA");
					  tipopagamentoInfo 				= rs.getString("TIPOPAGAMENTO");
					  totalInfoCalc 					= Convert.toDouble(rs.getString("TOTALVENDA").replace(",", "."));
					  totalInfo							= Convert.toCurrencyString(totalInfoCalc, 2);
									
					  qntDeAnimaisVendidos 				+= rs.getInt("QUANTIDADE");
					  valorTotalDevendas      			+= Convert.toDouble(rs.getString("TOTALVENDA").replace(",", "."));
					  
					 }

				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaInfoAnimal\n" + e);

			}

		}
	}

}
