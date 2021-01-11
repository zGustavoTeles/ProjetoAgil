package com.email;

import java.util.Random;
import com.auxiliares.Auxiliares;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.net.mail.Address;
import totalcross.net.mail.MailSession;
import totalcross.net.mail.Message;
import totalcross.net.mail.Part;
import totalcross.net.mail.Transport;
import totalcross.util.Date;
import totalcross.util.Properties;
import totalcross.net.mail.Message.RecipientType;
import totalcross.sys.Convert;
import totalcross.ui.dialog.ProgressBox;
import totalcross.ui.gfx.Color;

public class Email {

	/*
	 * Variaveis para construir o relatório
	 * de vendas realizadas por período há 
	 * ser enviado por e-mail
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
	 * de animais cadastrados há ser enviado
	 * por e-mail
	 */
	
	public int	 						 	codigoAnimalCad = 0;
	public String	 				 		descricaoAnimalCad = "";
	public int	 				 			quantidadeAnimalCad = 0;
	public String 				 			idadeAnimalCad = "";
	public String	 			 			sexoAnimalCad = "";
	public String 				 			racaAnimalCad = "";
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
	
	private static  String SMTP = "smtp.gmail.com";
	private static  String USUARIO = "alcateiaservicosonline@gmail.com";
	private static  String SENHA = "alcateia@@2031";
	private static  int PORTA = 465;

	
	public Email() throws Exception {
		
		SMTP = "smtp.gmail.com";
		USUARIO = "alcateiaservicosonline@gmail.com";
		SENHA = "alcateia@@2031";
		PORTA = 465;
	}
	
	

	public void enviaEmailVendasPeriodo(String dataI, String dataII, String emailEnvio) {

		try {
			
			ProgressBox pb = new ProgressBox("AGIL", "Enviando E-mail...", null);
			pb.setBackColor(Color.WHITE);
			pb.setForeColor(0x003366);
			pb.popupNonBlocking();

			MailSession session = MailSession.getInstance();
			session.put(MailSession.SMTP_HOST, new Properties.Str(SMTP));
			session.put(MailSession.SMTP_USER, new Properties.Str(USUARIO));
			session.put(MailSession.SMTP_PASS, new Properties.Str(SENHA));
			session.put(MailSession.SMTP_CONNECTIONTIMEOUT, new Properties.Int(60000));
			session.put(MailSession.SMTP_TIMEOUT, new Properties.Int(60000));
			session.put(MailSession.SMTP_STARTTLS, new Properties.Boolean(true));
			session.put(MailSession.SMTP_PORT, new Properties.Int(PORTA));

			String[] email = Convert.tokenizeString(emailEnvio, ",");
			Message myMessage = new Message();

			Address[] addresses = new Address[email.length];
			for (int i = 0; i < email.length; i++) {
				addresses[i] = new Address(email[i], "");
			}

			myMessage.addFrom(new Address[] { new Address(USUARIO, Auxiliares.NOMESISTEMA) });
			myMessage.addHeader("AGIL", "AGIL");
			myMessage.subject = "Email";
			myMessage.addRecipients(RecipientType.TO, addresses);

			/**
			 * Cria o relatorio por email das vendas realizadas no período.
			 */
			
			StringBuffer sb = null;
			sb = emailVendasPorPeriodo(dataI, dataII);

			/**
			 * Seta o conteudo da mensagem enviada.
			 */
			myMessage.setContent(sb.toString(), Part.HTML);

			try {

				Transport.send(myMessage, session);
				Auxiliares.messagebox("AGIL",
						"Relatório de vendas por período enviado para o e-mail: " + emailEnvio + "\nCom sucesso!\nVocê já pode conferir o e-mail informado...");

			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Email não enviado\n" + e);
			}
			
			pb.unpop();

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Email enviaEmailVendasPeriodo\n" + e);
		}
	}

	
	public StringBuffer emailVendasPorPeriodo(String dataI, String dataII) throws Exception {

		StringBuffer sb 						= new StringBuffer();
		String sql								= "";
		LitebasePack lb 						= null;
		ResultSet rs 							= null;		
		Random random 		    				= new Random();
		int codigoEnviaEmailVendas		 		= random.nextInt(900);
		String dataEnvioEmailVendas;
		Date year				 				= new Date();
		Date month 								= new Date();
		Date day = new Date();

		dataEnvioEmailVendas = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>");
		sb.append("<title>Pedido</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append(
				"<table width=\"1200\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" style=\"font-family:Arial,Helvetica,sans-serif\">");
		sb.append("<tbody>");
		sb.append("<tr>");
		sb.append(
				"<td colspan=\"3\" style=\"border:1px solid #c1c1c1;border-bottom:0px;padding:20px 20px 10px 20px;font-size:12px;color:#333333;line-height:18px\">");

		sb.append(
				"<table style=\"font-size:12px;color:#333333;line-height:25px;margin-top:20px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<tbody>");

		sb.append("<tr>");
		sb.append("<td align=\"right\" valign=\"top\" width=\"10%\"></td>");

		sb.append("<td valign=\"top\" width=\"90% \">");

		sb.append("<b>E-MAIL NUMERO: </b>" + codigoEnviaEmailVendas);
		sb.append("<br/><b>DATA E-MAIL: </b>" + dataEnvioEmailVendas);
		sb.append("<br/><b>RELATORIO DE VENDAS POR PERIODO ( AGIL - PC )</b>");
		

		sb.append("<table border=\"0\" width=\"95% \">");
		sb.append("<tr>");
		sb.append("<td><b>QUANTIDADE</b></td>");
		sb.append("<td align=\"center\"><b>DATA VENDA</b></td>");
		sb.append("<td align=\"center\"><b>IDADE</b></td>");
		sb.append("<td align=\"center\"><b>PASTAGEM</b></td>");
		sb.append("<td align=\"center\"><b>RACA</b></td>");
		sb.append("<td align=\"center\"><b>DESCRICAO</b></td>");
		sb.append("<td align=\"center\"><b>PRECO VENDA</b></td>");
		sb.append("<td align=\"center\"><b>TIPO PAGAMENTO</b></td>");
		sb.append("<td><b>TOTAL</b></td>");
		sb.append("</tr>");
		
		
		lb = new LitebasePack();
		
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
		
		sb.append("<td>" + quantidadeVendidaInfo + "</td>");
		sb.append("<td align=\"center\">" + dataVendaInfo + "</td>");
		sb.append("<td align=\"center\">" + idadeInfo + "</td>");
		sb.append("<td align=\"center\">" + pastagemInfo + "</td>");
		sb.append("<td align=\"center\">" + racaInfo + "</td>");
		sb.append("<td align=\"center\">" + descricaoInfo + "</td>");
		sb.append("<td align=\"center\">" + precoVendaInfo + "</td>");
		sb.append("<td align=\"center\">" + tipopagamentoInfo + "</td>");
		sb.append("<td> R$" + totalInfo + "</td>");
		sb.append("</tr>");
		
		
		}
		 
		sb.append("<br>");
		sb.append("<br>");
		
		sb.append("<table border=\"0\" width=\"95% \">");
		sb.append("<tr>");
		sb.append("<td><b>QUANTIDADE DE ANIMAIS VENDIDOS: </b></td>");
		sb.append("</tr>");
		
		sb.append("<td>" + qntDeAnimaisVendidos + "</td>");
		sb.append("</tr>");
		
		sb.append("<table border=\"0\" width=\"95% \">");
		sb.append("<tr>");
		sb.append("<td><b>VALOR TOTAL DAS VENDAS: </b></td>");
		sb.append("</tr>");
		
		sb.append("<td>" + Convert.toCurrencyString(valorTotalDevendas, 2) + "</td>");
		sb.append("</tr>");
			

		sb.append("</table>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("<p>");
		sb.append("&nbsp;");
		sb.append("</p>");
		sb.append("<p align=\"center\">");
		sb.append("Todos os direitos reservados - Alcateia Acessorios Eletronicos- Copyright ");
		sb.append("</p></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append(
				"<td height=\"9\" style=\"font-size:0;border:1px solid #c1c1c1;border-top:0\" colspan=\"3\"><img width=\"1200\" height=\"9\" src=\"http://i.imgur.com/zUVqqz5.gif\"/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append(
				"<td colspan=\"3\" style=\"font-size:11px;color:#666666;text-align:center;padding-top:15px\">N&atilde;o responda a este e-mail.</td>");
		sb.append("</tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");

		return sb;
	}
	
	public void enviaEmailAnimaisCadastrados(String emailEnvio) {

		try {
			
			ProgressBox pb = new ProgressBox("AGIL", "Enviando E-mail...", null);
			pb.setBackColor(Color.WHITE);
			pb.setForeColor(0x003366);
			pb.popupNonBlocking();

			MailSession session = MailSession.getInstance();
			session.put(MailSession.SMTP_HOST, new Properties.Str(SMTP));
			session.put(MailSession.SMTP_USER, new Properties.Str(USUARIO));
			session.put(MailSession.SMTP_PASS, new Properties.Str(SENHA));
			session.put(MailSession.SMTP_CONNECTIONTIMEOUT, new Properties.Int(60000));
			session.put(MailSession.SMTP_TIMEOUT, new Properties.Int(60000));
			session.put(MailSession.SMTP_STARTTLS, new Properties.Boolean(true));
			session.put(MailSession.SMTP_PORT, new Properties.Int(PORTA));

			String[] email = Convert.tokenizeString(emailEnvio, ",");
			Message myMessage = new Message();

			Address[] addresses = new Address[email.length];
			for (int i = 0; i < email.length; i++) {
				addresses[i] = new Address(email[i], "");
			}

			myMessage.addFrom(new Address[] { new Address(USUARIO, Auxiliares.NOMESISTEMA) });
			myMessage.addHeader("AGIL", "AGIL");
			myMessage.subject = "Email";
			myMessage.addRecipients(RecipientType.TO, addresses);

			/**
			 * Cria o relatorio por email de animais cadastrados.
			 */
			StringBuffer sb = null;
			sb = emailAnimaisCadastrados();

			/**
			 * Seta o conteudo da mensagem enviada.
			 */
			myMessage.setContent(sb.toString(), Part.HTML);

			try {

				Transport.send(myMessage, session);
				Auxiliares.messagebox("AGIL",
						"Relatório de animais cadastrados enviado para o e-mail: " + emailEnvio + "\nCom sucesso!\nVocê já pode conferir o e-mail informado...");

			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Email não enviado\n" + e);
			}
			
			pb.unpop();

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Email enviaEmailVendasPeriodo\n" + e);
		}
	}

	
	public StringBuffer emailAnimaisCadastrados() throws Exception {

		StringBuffer sb 						= new StringBuffer();
		String sql								= "";
		LitebasePack lb 						= null;
		ResultSet rs 							= null;		
		Random random 		    				= new Random();
		int codigoEnviaEmailAnimaisCad		 	= random.nextInt(900);
		String dataEnvioEmailAnimaisCad;
		Date year				 				= new Date();
		Date month 								= new Date();
		Date day = new Date();

		dataEnvioEmailAnimaisCad = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>");
		sb.append("<title>Pedido</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append(
				"<table width=\"1200\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" style=\"font-family:Arial,Helvetica,sans-serif\">");
		sb.append("<tbody>");
		sb.append("<tr>");
		sb.append(
				"<td colspan=\"3\" style=\"border:1px solid #c1c1c1;border-bottom:0px;padding:20px 20px 10px 20px;font-size:12px;color:#333333;line-height:18px\">");

		sb.append(
				"<table style=\"font-size:12px;color:#333333;line-height:25px;margin-top:20px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">");
		sb.append("<tbody>");

		sb.append("<tr>");
		sb.append("<td align=\"right\" valign=\"top\" width=\"10%\"></td>");

		sb.append("<td valign=\"top\" width=\"90% \">");

		sb.append("<b>E-MAIL NUMERO: </b>" + codigoEnviaEmailAnimaisCad);
		sb.append("<br/><b>DATA E-MAIL: </b>" + dataEnvioEmailAnimaisCad);
		sb.append("<br/><b>RELATORIO DE ANIMAIS CADASTRADOS ( AGIL - PC )</b>");
		

		sb.append("<table border=\"0\" width=\"95% \">");
		sb.append("<tr>");
		sb.append("<td><b>QUANTIDADE</b></td>");
		sb.append("<td align=\"center\"><b>DATA COMPRA</b></td>");
		sb.append("<td align=\"center\"><b>IDADE</b></td>");
		sb.append("<td align=\"center\"><b>PASTAGEM</b></td>");
		sb.append("<td align=\"center\"><b>RACA</b></td>");
		sb.append("<td align=\"center\"><b>DESCRICAO</b></td>");
		sb.append("<td align=\"center\"><b>PRECO VENDA</b></td>");
		sb.append("<td align=\"center\"><b>AFTOSA</b></td>");
		sb.append("<td><b>RAIVA</b></td>");
		sb.append("</tr>");
		
		
		lb = new LitebasePack();
		
		sql = " SELECT * FROM REBANHO ";
		
		
		 rs = lb.executeQuery(sql);
		 rs.beforeFirst();
				

	 while (rs.next()) {
					
		 codigoAnimalCad 								= rs.getInt("CODIGO");
		 descricaoAnimalCad 							= rs.getString("DESCRICAO");
		 quantidadeAnimalCad 							= rs.getInt("QUANTIDADE");
		 idadeAnimalCad 								= rs.getString("IDADE");					
		 sexoAnimalCad 									= rs.getString("SEXO");		
		 racaAnimalCad 									= rs.getString("RACA");
		 pesoAnimalCad 									= rs.getString("PESO");
		 dataCompraAnimalCad 							= rs.getString("DATACOMPRA");
		 precoCompraAnimalCad 							= rs.getString("PRECOCOMPRA");
		 precoVendaAnimalCad 							= rs.getString("PRECOVENDA");
		 statusAnimalCad 								= rs.getString("STATUS");
		 pastagemAnimalCad 								= rs.getString("PASTAGEM");
		 aftosaAnimalCad 								= rs.getString("AFTOSA");
		 raivaAnimalCad 								= rs.getString("RAIVA");
			
		 qntAnimaisCad 									+= rs.getInt("QUANTIDADE");
		 valorTotalAnimaisCadCalc      					+= Convert.toDouble(rs.getString("PRECOVENDA").replace(",", ".")) * quantidadeAnimalCad;		 

		 
		sb.append("<td>" + quantidadeAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + dataCompraAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + idadeAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + pastagemAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + racaAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + descricaoAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + precoVendaAnimalCad + "</td>");
		sb.append("<td align=\"center\">" + aftosaAnimalCad + "</td>");
		sb.append("<td>" + raivaAnimalCad + "</td>");
		sb.append("</tr>");
		
		
	 	}
	 
		valorTotalAnimaisCad 						 =  Convert.toCurrencyString(valorTotalAnimaisCadCalc, 2);
		 
		sb.append("<br>");
		sb.append("<br>");
		
		sb.append("<table border=\"0\" width=\"95% \">");
		sb.append("<tr>");
		sb.append("<td><b>VALOR TOTAL DOS ANIMAIS CADASTRADOS: </b></td>");
		sb.append("</tr>");
		
		sb.append("<td>  R$" + valorTotalAnimaisCad + "</td>");
		sb.append("</tr>");
			

		sb.append("</table>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("<p>");
		sb.append("&nbsp;");
		sb.append("</p>");
		sb.append("<p align=\"center\">");
		sb.append("Todos os direitos reservados - Alcateia Acessorios Eletronicos- Copyright ");
		sb.append("</p></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append(
				"<td height=\"9\" style=\"font-size:0;border:1px solid #c1c1c1;border-top:0\" colspan=\"3\"><img width=\"1200\" height=\"9\" src=\"http://i.imgur.com/zUVqqz5.gif\"/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append(
				"<td colspan=\"3\" style=\"font-size:11px;color:#666666;text-align:center;padding-top:15px\">N&atilde;o responda a este e-mail.</td>");
		sb.append("</tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");

		return sb;
	}
}