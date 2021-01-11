package com.pdf;

import java.util.Random;
import com.auxiliares.Auxiliares;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.io.File;
import totalcross.sys.Convert;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.dialog.ProgressBox;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;
import totalcross.util.pdf.PDFWriter;
import totalcross.util.pdf.PaperSize;
import totalcross.util.pdf.StandardFonts;

public class Pdf {
	
	private ProgressBox 					pb;
	
	
	/*
	 * Variaveis para construir o relatório
	 * em PDF das vendas por período
	 */
	
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

	/*
	 * Variaveis para construir o relatório
	 * em PDF dos animais cadastrados
	 */
	
	public int	 						 	codigoAnimalCad = 0;
	public String	 				 		descricaoAnimalCad = "";
	public int	 				 			quantidadeAnimalCad = 0;
	public String 				 			idadeAnimalCad = "";
	public String	 			 			sexoAnimalCad = "";
	public String 				 			racaAnimaCad = "";
	public String 				 			pesoAnimalCad = "";
	public String 				 			dataCompraAnimalCad = "";
	public String 				 			precoCompraAnimalCad = "";
	public String 				 			precoVendaAnimalCad = "";
	public String 				 			statusAnimalCad = "";
	public String 				 			pastagemAnimalCad = "";
	public String 				 			aftosaAnimalCad = "";
	public String 				 			raivaAnimalCad = "";
	
	public int								qntAnimaisCad = 0;
	public String							valorTotalAnimaisCad = "";
	public double							valorTotalAnimaisCadCalc = 0.00;
	
	public Pdf() throws Exception {
	
	}
	
	
	public String limitaString(String texto, int maximo) {
		return texto.length() <= maximo ? texto : texto.substring(0, maximo);
	}

	public void gerarPDFDeVenda(String dataI, String dataII) {

		try {
			
				String sql								= "";
				LitebasePack lb 						= null;
				ResultSet rs 							= null;
				PDFWriter PDF 							= new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);
					
				Random random 		    				= new Random();
				int codigoPDF		 					= random.nextInt(900);
				
				String dataGeracaoPDF;
				Date year				 				= new Date();
				Date month 								= new Date();
				Date day = new Date();

				dataGeracaoPDF = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());
			
				// note that to make this images snippet work
				// you have to uncompress the assets.zip file
				// included into your project assets folder
			
				Image img					   			= new Image("img/pdfLogo.png");
				lb 										= new LitebasePack();	
				
				
				pb = new ProgressBox("Aguarde!", "Gerando PDF...", null);
				pb.setBackColor(Color.WHITE);
				pb.setForeColor(0x003366);
				pb.popupNonBlocking();

 					// Cabeçalho ---------------------------------------------------------------
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER, "UTF");
					PDF.addRectangle(20, 750, 560, 160);
					PDF.addImage(25, 840, 175, 60, img);
					PDF.addText(210, 890, 12, "ALCATEIA ACESSÓRIOS ELETRÔNICOS");
					PDF.addText(210, 880, 12, "CNPJ: 09.697.133/0001-11");
					PDF.addText(210, 870, 11, "AV. MAJOR MANOEL ALGUSTO");
					PDF.addText(210, 860, 11, "GOIANIA - GO");
					PDF.addText(210, 850, 11, "TELEFONE: 3481-3422");
					PDF.addText(210, 840, 11, "EMAIL: alcateiaservicosonline@gmail.com");
					PDF.addLine(20,  835, 580, 835);
					PDF.addText(270, 822, 12, "RELATORIO");
					PDF.addLine(20,  790, 580, 790);
					// Fim Cabeçalho ---------------------------------------------------------------
					// Dados do Pedido
					// ---------------------------------------------------------------
					
					// Coluna de Vendas
					
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(22,   765,  8, "QNT:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(55,   765,  8, "VENDA:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(120,  765,  8, "IDADE:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(200,  765,  8, "PASTAGEM:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(285,  765,  8, "RACA:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(350,  765,  8, "DESCRICAO:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(435,  765, 	8, "VALOR:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(485,  765,  8, "PAGAMENTO:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(540,  765,  8, "TOTAL:");
					
					int posicaoLinha = 740;

						
					sql = " SELECT * FROM VENDAANIMAL "
							+ " WHERE DATAVENDA >= " + "'" + dataI + "'"
							+ " AND DATAVENDA <= " + "'" + dataII + "'";
								
								
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
							 
						 
						
					// Colunas dos itens
					PDF.addText(22,   posicaoLinha, 8, ""      + quantidadeVendidaInfo);
					PDF.addText(55,   posicaoLinha, 8, ""      + dataVendaInfo.toString());
					PDF.addText(120,  posicaoLinha, 8, "" 	   + idadeInfo);
					PDF.addText(200,  posicaoLinha, 8, "" 	   + pastagemInfo);
					PDF.addText(285,  posicaoLinha, 8, "" 	   + racaInfo);
					PDF.addText(350,  posicaoLinha, 8, "" 	   + descricaoInfo);
					PDF.addText(435,  posicaoLinha, 8, ""      + precoVendaInfo);
					PDF.addText(485,  posicaoLinha, 8, ""	   + tipopagamentoInfo);
					PDF.addText(530,  posicaoLinha, 8, ""	   + totalInfo);
					posicaoLinha -= 10;
					
					
					
					}

					PDF.addLine(20, posicaoLinha, 580, posicaoLinha);
					posicaoLinha -= 10;

					PDF.addText(450, posicaoLinha, 8, "Animais Vendidos..: "+ qntDeAnimaisVendidos);
					posicaoLinha -= 16;

					PDF.addRectangle(20, posicaoLinha, 560, 13);
					PDF.addText(22, posicaoLinha + 2, 9, "Relatorio de venda(s) numero: " + Convert.toString(codigoPDF));
					posicaoLinha -= 10;

					PDF.addText(22, posicaoLinha, 8, "Relatorio gerado no dia: "
									+ dataGeracaoPDF.toString());
					
				    PDF.addText(380, posicaoLinha, 9, "Total do(s) Servico(s)..: " + "0,00");
				    posicaoLinha -= 10;

					PDF.addText(22, posicaoLinha,  8, "Condicao de Pagamento: " + "DINHEIRO, CARTAO OU CHEQUE");
					PDF.addText(380, posicaoLinha, 9, "Total de Descontos.......:" + "0,00");
					posicaoLinha -= 10;

					PDF.addText(380, posicaoLinha, 9, "Outras Despesas..........:" + "0,00");
					posicaoLinha -= 10;

					PDF.addText(380, posicaoLinha, 9, "Total de frete(s)........:" + "0,00");
					posicaoLinha -= 10;

					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(22, posicaoLinha, 9, "NAO E VALIDO COMO GARANTIA DE MERCADORIA ");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(380, posicaoLinha, 9,
									"TOTAL DE VENDA(S): " + Convert.toCurrencyString(valorTotalDevendas, 2));
					posicaoLinha -= 10;

					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(22, posicaoLinha, 9, "NAO E VALIDO COMO DOCUMENTO FISCAL ");
					posicaoLinha -= 10;

					posicaoLinha -= 20;

					PDF.addText(22, posicaoLinha, 9, "OBSERVACAO:");							


			int pageCount = PDF.getPageCount();
			for (int i = 0; i < pageCount; i++) {
				PDF.setCurrentPage(i);
				PDF.addText(10, 10, 8, Integer.toString(i + 1) + " / " + Integer.toString(pageCount));
			}

			File diretorioPedidos = new File("Relatórios_De_Vendas");
			if (!diretorioPedidos.isDir()) {
				diretorioPedidos.createDir();
			}

			String s = PDF.asString();
//			final String name = Settings.platform.equals(Settings.ANDROID) ? "/sdcard/"+ "Relatorio" + codigoPDF + ".pdf":Settings.appPath +"Pedidos/"+ "Relatorio_Animais_Numero_" + codigoPDF +".pdf";
			
//			File f = new File(name, File.CREATE_EMPTY);
			File f = new File("Relatórios_De_Vendas/" + "Relatório_De_Vendas_Número_" + codigoPDF + ".pdf", File.CREATE_EMPTY);
			f.writeBytes(s.getBytes());
			f.close();
//			if (Settings.platform.equalsIgnoreCase(Settings.ANDROID)) {
//				Vm.exec("viewer", name, 0, true);
//			}
			// FuncoesAuxiliares.MsgBox("PDF Writter created by Javier Santo Domingo");
			
			pb.unpop();
			Auxiliares.messagebox("AGIL", "Relatório em PDF de vendas por período gerado com sucesso! ");
			
		} catch (Exception e) {
			MessageBox.showException(e, true);
			pb.unpop();
		}

	}
	
	public void gerarPDFDeCadAnimais() {

		try {
			
				String sql								= "";
				LitebasePack lb 						= null;
				ResultSet rs 							= null;
				PDFWriter PDF 							= new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);
					
				Random random 		    				= new Random();
				int codigoPDF		 					= random.nextInt(900);
				
				String dataGeracaoPDF;
				Date year				 				= new Date();
				Date month 								= new Date();
				Date day = new Date();

				dataGeracaoPDF = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());
			
				// note that to make this images snippet work
				// you have to uncompress the assets.zip file
				// included into your project assets folder
			
				Image img					   			= new Image("img/pdfLogo.png");
				lb 										= new LitebasePack();	
				
				
				pb = new ProgressBox("Aguarde!", "Gerando PDF...", null);
				pb.setBackColor(Color.WHITE);
				pb.setForeColor(0x003366);
				pb.popupNonBlocking();

 					// Cabeçalho ---------------------------------------------------------------
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER, "UTF");
					PDF.addRectangle(20, 750, 560, 160);
					PDF.addImage(25, 840, 175, 60, img);
					PDF.addText(210, 890, 12, "ALCATEIA ACESSÓRIOS ELETRÔNICOS");
					PDF.addText(210, 880, 12, "CNPJ: 09.697.133/0001-11");
					PDF.addText(210, 870, 11, "AV. MAJOR MANOEL ALGUSTO");
					PDF.addText(210, 860, 11, "GOIANIA - GO");
					PDF.addText(210, 850, 11, "TELEFONE: 3481-3422");
					PDF.addText(210, 840, 11, "EMAIL: alcateiaservicosonline@gmail.com");
					PDF.addLine(20,  835, 580, 835);
					PDF.addText(270, 822, 12, "RELATORIO");
					PDF.addLine(20,  790, 580, 790);
					// Fim Cabeçalho ---------------------------------------------------------------
					// Dados do Pedido
					// ---------------------------------------------------------------
					
					// Coluna de Vendas
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(22,   765,  8, "QNT:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(55,   765,  8, "COMPRA:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(120,  765,  8, "IDADE:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(200,  765,  8, "PASTAGEM:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(285,  765,  8, "RACA:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(350,  765,  8, "DESCRICAO:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(435,  765, 	8, "VALOR:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(485,  765,  8, "AFTOSA:");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(540,  765,  8, "RAIVA:");
					
					int posicaoLinha = 740;

						
					sql = " SELECT * FROM REBANHO ";
								
								
						 rs = lb.executeQuery(sql);
						 rs.beforeFirst();
								

					 while (rs.next()) {
									
					codigoAnimalCad 							= rs.getInt("CODIGO");
					descricaoAnimalCad 							= rs.getString("DESCRICAO");
					quantidadeAnimalCad 						= rs.getInt("QUANTIDADE");
					idadeAnimalCad 								= rs.getString("IDADE");					
					sexoAnimalCad 								= rs.getString("SEXO");		
					racaAnimaCad 								= rs.getString("RACA");
					pesoAnimalCad 								= rs.getString("PESO");
					dataCompraAnimalCad 						= rs.getString("DATACOMPRA");
					precoCompraAnimalCad 						= rs.getString("PRECOCOMPRA");
					precoVendaAnimalCad 						= rs.getString("PRECOVENDA");
					statusAnimalCad 							= rs.getString("STATUS");
					pastagemAnimalCad 							= rs.getString("PASTAGEM");
					aftosaAnimalCad 							= rs.getString("AFTOSA");
					raivaAnimalCad 								= rs.getString("RAIVA");
							
					qntAnimaisCad 								+= rs.getInt("QUANTIDADE");
					valorTotalAnimaisCadCalc      				+= Convert.toDouble(rs.getString("PRECOVENDA").replace(",", ".")) * quantidadeAnimalCad;		 
						 
						
					// Colunas dos itens
					PDF.addText(22,   posicaoLinha, 8, ""      + quantidadeAnimalCad);
					PDF.addText(55,   posicaoLinha, 8, ""      + dataCompraAnimalCad.toString());
					PDF.addText(120,  posicaoLinha, 8, "" 	   + idadeAnimalCad);
					PDF.addText(200,  posicaoLinha, 8, "" 	   + pastagemAnimalCad);
					PDF.addText(285,  posicaoLinha, 8, "" 	   + racaAnimaCad);
					PDF.addText(350,  posicaoLinha, 8, "" 	   + descricaoAnimalCad);
					PDF.addText(435,  posicaoLinha, 8, ""      + precoVendaAnimalCad);
					PDF.addText(485,  posicaoLinha, 8, ""	   + limitaString(aftosaAnimalCad, 8));
					PDF.addText(530,  posicaoLinha, 8, ""	   + limitaString(raivaAnimalCad, 8));
					posicaoLinha -= 10;
					
					
					
					}
					 
					valorTotalAnimaisCad 						 =  Convert.toCurrencyString(valorTotalAnimaisCadCalc, 2);

					PDF.addLine(20, posicaoLinha, 580, posicaoLinha);
					posicaoLinha -= 10;

					PDF.addText(450, posicaoLinha, 8, "Animais Cadastrados..: "+ qntAnimaisCad);
					posicaoLinha -= 16;

					PDF.addRectangle(20, posicaoLinha, 560, 13);
					PDF.addText(22, posicaoLinha + 2, 9, "Relatorio de animal(s) numero: " + Convert.toString(codigoPDF));
					posicaoLinha -= 10;

					PDF.addText(22, posicaoLinha, 8, "Relatorio gerado no dia: "
									+ dataGeracaoPDF.toString());
					
				    PDF.addText(380, posicaoLinha, 9, "Total do(s) Servico(s)..: " + "0,00");
				    posicaoLinha -= 10;

					PDF.addText(22, posicaoLinha,  8, "Condicao de Pagamento: " + "DINHEIRO, CARTAO OU CHEQUE");
					PDF.addText(380, posicaoLinha, 9, "Total de Descontos.......:" + "0,00");
					posicaoLinha -= 10;

					PDF.addText(380, posicaoLinha, 9, "Outras Despesas..........:" + "0,00");
					posicaoLinha -= 10;

					PDF.addText(380, posicaoLinha, 9, "Total de frete(s)........:" + "0,00");
					posicaoLinha -= 10;

					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(22, posicaoLinha, 9, "NAO E VALIDO COMO GARANTIA DE MERCADORIA ");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(380, posicaoLinha, 9,
									"VALOR TOTAL DOS ANIMAIS..: " + valorTotalAnimaisCad);
					posicaoLinha -= 10;

					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(22, posicaoLinha, 9, "NAO E VALIDO COMO DOCUMENTO FISCAL ");
					posicaoLinha -= 10;

					posicaoLinha -= 20;

					PDF.addText(22, posicaoLinha, 9, "OBSERVACAO:");							


			int pageCount = PDF.getPageCount();
			for (int i = 0; i < pageCount; i++) {
				PDF.setCurrentPage(i);
				PDF.addText(10, 10, 8, Integer.toString(i + 1) + " / " + Integer.toString(pageCount));
			}
			
			
			File diretorioPedidos = new File("Relatórios_De_Animais_Cadastrados");
			if (!diretorioPedidos.isDir()) {
				diretorioPedidos.createDir();
			}

			String s = PDF.asString();
//			final String name = Settings.platform.equals(Settings.ANDROID) ? "/sdcard/"+ "Relatorio" + codigoPDF + ".pdf":Settings.appPath +"Pedidos/"+ "Relatorio_Animais_Numero_" + codigoPDF +".pdf";
			
//			File f = new File(name, File.CREATE_EMPTY);
			File f = new File("Relatórios_De_Animais_Cadastrados/" + "Relatório_De_Animais_Número_" + codigoPDF + ".pdf", File.CREATE_EMPTY);
			f.writeBytes(s.getBytes());
			f.close();
//			if (Settings.platform.equalsIgnoreCase(Settings.ANDROID)) {
//				Vm.exec("viewer", name, 0, true);
//			}
			// FuncoesAuxiliares.MsgBox("PDF Writter created by Javier Santo Domingo");
			
			pb.unpop();
			Auxiliares.messagebox("AGIL", "Relatório em PDF de animais cadastrados gerado com sucesso! ");
			
		} catch (Exception e) {
			MessageBox.showException(e, true);
			pb.unpop();
		}

	}
	
	public void gerarPDFReciboPagamento() {

		try {
			
				String sql								= "";
				LitebasePack lb 						= null;
				ResultSet rs 							= null;
				PDFWriter PDF 							= new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);
					
				Random random 		    				= new Random();
				int codigoPDF		 					= random.nextInt(900);
				
				String dataGeracaoPDF;
				Date year				 				= new Date();
				Date month 								= new Date();
				Date day = new Date();

				dataGeracaoPDF = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());
			
				// note that to make this images snippet work
				// you have to uncompress the assets.zip file
				// included into your project assets folder
			
				lb 										= new LitebasePack();	
				
				
				pb = new ProgressBox("Aguarde!", "Gerando PDF...", null);
				pb.setBackColor(Color.WHITE);
				pb.setForeColor(0x003366);
				pb.popupNonBlocking();

 					// Cabeçalho ---------------------------------------------------------------
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER, "UTF");
					PDF.addRectangle(20, 630, 560, 160);
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(200, 792, 14, "RECIBO PAGAMENTO");
					PDF.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
					PDF.addText(475, 792, 14, "VALOR (		        	)");
					PDF.addLine(20,  790, 580, 790);
					// Fim Cabeçalho ---------------------------------------------------------------
					// Dados do Pedido
					// ---------------------------------------------------------------
					
					// Coluna de Vendas
					PDF.addText(22,   765,  12, "RECEBI DE: " + "FAZENDA BOY GORDO");
					PDF.addText(22,   745,  12, "ENDERECO: " + "AV. MAJOR MANOEL ALGUSTO");
					PDF.addText(22,   725,  12, "CNPJ: " + "CNPJ: 09.697.133/0001-11");
					PDF.addText(22,   715,  12, "CIDADE: " + "GOIANIA (GO)");
					
					PDF.addText(350,  745,  12, "INSCR:" + "   --");
					PDF.addText(350,  725,  12, "TELEFONE:" + "(62) 3481-3422");
					PDF.addText(350,  715,  12, "ESTADO:" + "  GO");
					
																   
					PDF.addText(22,   695,  12, "IMPORTANCIA: " + "_____________________________________________________");		
					PDF.addText(22,   675,  12, "ASSINATURA:" + "  _____________________________________________________");
					PDF.addText(22,   650,  12, "TELEFONE: " + "(62) 9 854-3326");
					PDF.addText(22,   640,  12, "CPF/CNPJ: " + "123.123.563-00");						


			int pageCount = PDF.getPageCount();
			for (int i = 0; i < pageCount; i++) {
				PDF.setCurrentPage(i);
				PDF.addText(10, 10, 8, Integer.toString(i + 1) + " / " + Integer.toString(pageCount));
			}
			
			
			File diretorioPedidos = new File("Recibos_De_Pagamentos");
			if (!diretorioPedidos.isDir()) {
				diretorioPedidos.createDir();
			}

			String s = PDF.asString();
//			final String name = Settings.platform.equals(Settings.ANDROID) ? "/sdcard/"+ "Relatorio" + codigoPDF + ".pdf":Settings.appPath +"Pedidos/"+ "Relatorio_Animais_Numero_" + codigoPDF +".pdf";
			
//			File f = new File(name, File.CREATE_EMPTY);
			File f = new File("Recibos_De_Pagamentos/" + "Recibo_De_Pagamento_Número_" + codigoPDF + ".pdf", File.CREATE_EMPTY);
			f.writeBytes(s.getBytes());
			f.close();
//			if (Settings.platform.equalsIgnoreCase(Settings.ANDROID)) {
//				Vm.exec("viewer", name, 0, true);
//			}
			// FuncoesAuxiliares.MsgBox("PDF Writter created by Javier Santo Domingo");
			
			pb.unpop();
			Auxiliares.messagebox("AGIL", "Recibo de pagamento gerado com sucesso! ");
			
		} catch (Exception e) {
			MessageBox.showException(e, true);
			pb.unpop();
		}

	}

}

