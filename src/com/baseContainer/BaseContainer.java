package com.baseContainer;

import javax.annotation.PreDestroy;

import com.auxiliares.Auxiliares;
import com.sun.javafx.geom.AreaOp.AddOp;

import totalcross.res.Resources;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Container;
import totalcross.ui.MainWindow;
import totalcross.ui.UIColors;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.ElementNotFoundException;
import totalcross.util.Vector;

public class BaseContainer extends Container {
	public static final int BKGCOLOR = 0x363D40;
	public static final int SELCOLOR = 0x363D40; // Color.brighter(BKGCOLOR,120);
	public static  Bar headerBar,footerBar;
	protected String helpMessage="Mensagem meramente demonstrativa.";	
	private static Image infoImg;
	private static Image searchImg;
	private String defaultTitle = "";
	private static Vector containerStack = new Vector(5);
	/**
	 * Se o container implementa filtro ou não.
	 */
	private boolean filter = false;
	/**
	 * Se a classe � uma classe que permite sair da aplica��o ou não.
	 */
	private boolean isMainMenu;

	/**
	 * 
	 * @param filter
	 * @param isMainMenu
	 */
	
	public BaseContainer(boolean filter,boolean isMainMenu) {
		this.filter = filter;
		this.isMainMenu=isMainMenu;
	}
	

	public void initUI() {
		try {
			
			if (infoImg == null)
				infoImg = new Image("img/alterar.png");
			if (searchImg == null)
				searchImg = new Image("img/alterar.png");
			Font f = Auxiliares.getFontNormal();
			headerBar = new Bar(defaultTitle);
			headerBar.setFont(Auxiliares.getFontNormal());
			headerBar.setFont(f);
			headerBar.titleAlign=CENTER;
			headerBar.setBackForeColors(BKGCOLOR, Color.WHITE);
			if (filter) {

				headerBar.addButton(searchImg);

			}
			


			headerBar.addButton(infoImg);
			headerBar.addButton(isMainMenu ? Resources.exit : Resources.back);
			add(headerBar, LEFT, 0, FILL, PREFERRED);

			headerBar.addPressListener(new PressListener() {
				public void controlPressed(ControlEvent e) {
					e.consumed = true;
					try {
						if (filter) {
							switch (((Bar) e.target).getSelectedIndex()) {
							case 1: {
							
								searchAction();
								break;
							}
							case 2: {
							
								helpAction();
								break;
							}
							case 3: {
							
								backAction();
								break;
							}
							}
						} else {
							switch (((Bar) e.target).getSelectedIndex()) {
							case 1: {

								helpAction();
								break;
							}
							case 2: {

								backAction();
								break;
							}
							}

						}
					} catch (Exception ee) {
						Auxiliares.messagebox("ERRO","ERRO\n" + ee);
					}
				}
			});

			String name = getClass().getName();
			setTitle(name.endsWith("Samples") ? name.substring(
					name.lastIndexOf('.') + 1, name.length() - 7)
					+ " samples" : defaultTitle);
		} catch (Exception ee) {
			Auxiliares.messagebox("ERRO","ERRO\n" + ee);
		}
	}
	
	protected void setHeaderEnabled(boolean value){		
		headerBar.setEnabled(value);
	}

	public static void footerBar() throws Exception {
		try {			
		footerBar = new Bar("Artnew Tecnologia");
		footerBar.setFont(Auxiliares.getFontNormal());
		 footerBar.uiAdjustmentsBasedOnFontHeightIsSupported = false;
		 footerBar.setFont(Font.getFont(Font.DEFAULT, false, 20));
		 footerBar.titleAlign = CENTER;
		 footerBar.backgroundStyle = BACKGROUND_SOLID;
		 Image img = new Image("img/alterar.png");
		 img.transparentColor=0;
		 footerBar.setIcon(img);
		 footerBar.setBackForeColors(BKGCOLOR,Color.WHITE);
		 footerBar.setFont(Auxiliares.getFontNormal());
		 footerBar.setRect(LEFT + 2, BOTTOM, PREFERRED, PREFERRED);
		} catch (Exception e) {
		throw new Exception("footerBar()|"+e.getMessage());
		}
	}
	
	   public void show()
	   {
	      containerStack.push(this); // push ourself
	      Window.getTopMost().swap(this);
	   }
	   
	   
	   public void back()
	   {
	      try
	      {
	         containerStack.pop(); // pop ourself
	         Window.getTopMost().swap((Container)containerStack.peek());
	      }
	      catch (ElementNotFoundException enfe)
	      {
	         MainWindow.exit(0); // we're the last screen, so just exit the application
	      }
	   }

	protected void searchAction() throws Exception {		
		
	}

	protected void backAction() throws Exception {
		
	}

	protected void helpAction() throws Exception {
        	Font fontLocal = Font.getFont(false, 14);
			MessageBox mb = new MessageBox("Artvendas - "+Auxiliares.VERSAO,Convert.insertLineBreak(Settings.screenWidth-13,fontLocal.fm,helpMessage),new String[]{"Ok"});			
			mb.footerColor = mb.headerColor = UIColors.messageboxBack;
			mb.setTextAlignment(Container.LEFT);
			mb.setFont(fontLocal);
			mb.setIcon(infoImg);
			mb.popup();
	}

	public void setTitle(String s) {
		headerBar.setTitle(s);
	}

	public String getTitle() {
		return headerBar.getTitle();
	}

}
