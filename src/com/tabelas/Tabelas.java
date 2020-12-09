package com.tabelas;

import com.auxiliares.Auxiliares;
import com.litebase.LitebasePack;

public class Tabelas {
	
	public Tabelas() {
		criaTabelas();
	}
	
	public void criaTabelas() {
		
		LitebasePack lb 		      = null;
		String sql				 	  = "";
		
		try {

			try {
				
					lb = new LitebasePack();
					
//---------------------------------------------------------------------------------------------------------------------------------------					
					if (!lb.exists("RACA")) {

						sql = " create table raca ( " + "codigo int," + " descricao char(40), " + "categoria char(30)," 
						    + "codigorebanho int" + ")";

					lb.execute(sql);
					lb.execute("create index raca01 ON raca(codigo,descricao, categoria, codigorebanho)");
					
					}
//--------------------------------------------------------------------------------------------------------------------------------------------						
				if (!lb.exists("CATEGORIA")) {

					sql = " create table categoria ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index categoria01 ON categoria(codigo,descricao)");

				}

//--------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("DESCRICAO")) {

					sql = " create table descricao ( " + "codigo int," + " descricao char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index descricao01 ON descricao(codigo,descricao)");
					
				}
//-------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("peso")) {

					sql = " create table peso ( " + "codigo int," + " descricao char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index peso01 ON peso(codigo,descricao)");
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('1', '1-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('2', '1,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('3', '1,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('4', '1,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('5', '1,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('6', '1,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('7', '1,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('8', '1,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('9', '1,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('10', '1,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('11', '2-KL')";
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('12', '2,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('13', '2,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('14', '2,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('15', '2,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('16', '2,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('17', '2,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('18', '2,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('19', '2,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('20', '2,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('21', '3-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('22', '3,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('23', '3,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('24', '3,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('25', '3,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('26', '3,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('27', '3,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('28', '3,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('29', '3,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('30', '3,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('31', '4-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('32', '4,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('33', '4,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('34', '4,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('35', '4,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('36', '4,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('37', '4,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('38', '4,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('39', '4,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('40', '4,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('40', '4,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('41', '5-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('42', '5,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('43', '5,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('44', '5,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('45', '5,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('46', '5,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('47', '5,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('48', '5,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('49', '5,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('50', '5,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('51', '6-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('52', '6,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('53', '6,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('54', '6,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('55', '6,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('56', '6,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('57', '6,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('58', '6,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('59', '6,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('60', '6,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('61', '7-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('52', '7,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('53', '7,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('54', '7,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('55', '7,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('56', '7,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('57', '7,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('58', '7,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('59', '7,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('60', '7,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('61', '8-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('62', '8,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('63', '8,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('64', '8,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('65', '8,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('66', '8,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('67', '8,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('68', '8,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('69', '8,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('70', '8,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('71', '9-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('72', '9,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('73', '9,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('74', '9,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('75', '9,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('76', '9,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('77', '9,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('78', '9,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('79', '9,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('80', '9,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('81', '10-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('82', '10,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('83', '10,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('84', '10,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('85', '10,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('86', '10,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('87', '10,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('88', '10,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('89', '10,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('90', '10,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('91', '11-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('92', '11,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('93', '11,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('94', '11,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('95', '11,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('96', '11,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('97', '11,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('98', '11,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('99', '11,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('100', '11,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('101', '12-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('102', '12,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('103', '12,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('104', '12,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('105', '12,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('106', '12,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('107', '12,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('108', '12,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('109', '12,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('110', '12,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('111', '13-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('112', '13,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('113', '13,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('114', '13,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('115', '13,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('116', '13,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('117', '13,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('118', '13,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('119', '13,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('120', '13,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('121', '14-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('122', '14,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('113', '14,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('114', '14,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('115', '14,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('116', '14,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('117', '14,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('118', '14,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('119', '14,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('120', '14,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('121', '15-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('122', '15,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('123', '15,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('124', '15,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('125', '15,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('126', '15,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('127', '15,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('128', '15,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('129', '15,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('130', '15,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('131', '16-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('132', '16,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('133', '16,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('134', '16,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('135', '16,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('136', '16,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('137', '16,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('138', '16,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('139', '16,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('140', '16,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('141', '17-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('142', '17,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('143', '17,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('144', '17,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('145', '17,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('146', '17,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('147', '17,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('148', '17,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('149', '17,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('150', '17,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('151', '18-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('152', '18,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('153', '18,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('154', '18,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('155', '18,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('156', '18,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('157', '18,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('158', '18,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('159', '18,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('160', '18,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('161', '19-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('162', '19,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('163', '19,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('164', '19,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('165', '19,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('166', '19,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('167', '19,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('168', '19,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('169', '19,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('170', '19,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('171', '20-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('172', '20,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('173', '20,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('174', '20,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('175', '20,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('176', '20,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('177', '20,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('178', '20,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('179', '20,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('180', '20,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('181', '21-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('182', '21,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('183', '21,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('184', '21,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('185', '21,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('186', '21,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('187', '21,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('188', '21,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('189', '21,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('190', '21,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('191', '22-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('192', '22,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('193', '22,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('194', '22,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('195', '22,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('196', '22,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('197', '22,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('198', '22,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('199', '22,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('200', '22,900-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('201', '23-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('202', '23,100-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('203', '23,200-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('204', '23,300-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('205', '23,400-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('206', '23,500-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('207', '23,600-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('208', '23,700-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('209', '23,800-KL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO peso (codigo, descricao)" + " VALUES " + " ('210', '23,900-KL')";

					lb.executeUpdate(sql);


				}

//--------------------------------------------------------------------------------------------------------------------------------------	
				if (!lb.exists("REBANHO")) {

					sql = " create table rebanho ( " + "codigo int," + " descricao char(80), " +  " idade int,"
					   +  " sexo char(20), "  +  " raca char(50), " +  " peso char(30), " +  " datacompra date, "  
					   +  " precoCompra char(30)," + " precoAtual char(30), " + " status char(20), " + " setor char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index rebanho01 ON rebanho(codigo,tipo,categoria)");

				}
//-----------------------------------------------------------------------------------------------------------------------------------------
//				if (!lb.exists("VENDA")) {
//
//					sql = " create table vendaproduto ( " + "codigo int," +  "codigoProd int," + " produto char(40), " + " valor char(10), "
//							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
//							+ "tipopagamento char(20)," + "datasaida date"
//							+ ")";
//
//					lb.execute(sql);
//					lb.execute("create index vendaproduto01 ON vendaproduto(codigo,produto)");
//				}
////------------------------------------------------------------------------------------------------------------------------------------------
//				if (!lb.exists("VENDATEMP")) {
//
//					sql = " create table vendaprodutoTemp ( " + "codigo int," +  "codigoProd int," + " produto char(40), " + " valor char(10), "
//							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
//							+ "tipopagamento char(20)," + "datasaida date"
//							+ ")";
//
//					lb.execute(sql);
//					lb.execute("create index vendaprodutoTemp01 ON vendaprodutoTemp(codigo,produto)");
//				}
//------------------------------------------------------------------------------------------------------------------------------------------
//				if (!sqlite.exists("EMPRESA")) {
//
//					sql = " create table empresa ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
//						+ " usuario char(40), " + " datacadastro date " + ")";
//
//					sqlite.execute(sql);
//					sqlite.execute("create index empresa01 ON empresa(codigo,nome)");
//				}
				if (!lb.exists("USUARIO")) {

					sql = " create table usuario ( " + "codigo int," +  "usuario char(80)," +  "senha char(80)," + "salvar_senha char(1) " + ")";

					lb.execute(sql);
					lb.execute("create index usuario01 ON usuario(codigo, usuario,senha)");
				}	
//-------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("ADMINISTRADOR")) {

					sql = " create table administrador ( " + "codigo int," + " senha char(40) "+")";

					lb.execute(sql);
					lb.execute("create index administrador01 ON administrador(codigo,senha)");
				}
//--------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("TIPOPAGAMENTO")) {

					sql = " create table tipopagamento ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index tipopagamento01 ON tipopagamento(codigo,descricao)");

					sql = " INSERT INTO tipopagamento (codigo, descricao)" 
					    + " VALUES " + " ('01', 'DINHEIRO')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO tipopagamento (codigo, descricao)" 
					    + " VALUES " + " ('02', 'CARTAO')";

					lb.executeUpdate(sql);

				}
				
			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
				Auxiliares.messagebox("Erro", "Erro\n" + e);
			}
			
		}

}

