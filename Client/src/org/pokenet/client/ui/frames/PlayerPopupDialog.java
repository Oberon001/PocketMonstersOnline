package org.pokenet.client.ui.frames;

import mdes.slick.sui.Button;
import mdes.slick.sui.Frame;
import mdes.slick.sui.Label;
import mdes.slick.sui.event.ActionEvent;
import mdes.slick.sui.event.ActionListener;

import org.newdawn.slick.Color;
import org.pokenet.client.GameClient;

/**
 * Popup for right click on players
 * @author ZombieBear
 *
 */
public class PlayerPopupDialog extends Frame{
	Button m_battle, m_trade, m_addFriend, m_cancel;
	Label m_name;
	
	/**
	 * Default Constructor
	 * @param player
	 */
	public PlayerPopupDialog(String player){
		m_name = new Label(player);
		m_name.setFont(GameClient.getFontSmall());
		m_name.setForeground(Color.white);
		m_name.pack();
		m_name.setLocation(0,0);
		getContentPane().add(m_name);

		m_battle = new Button("Battle");
		m_battle.setSize(100,25);
		m_battle.setLocation(0, m_name.getY() + m_name.getTextHeight() + 3);
		getContentPane().add(m_battle);
		
		m_trade = new Button("Trade");
		m_trade.setSize(100,25);
		m_trade.setLocation(0, m_battle.getY() + m_battle.getHeight());
		getContentPane().add(m_trade);

		m_addFriend = new Button("Add Friend");
		m_addFriend.setSize(100,25);
		m_addFriend.setLocation(0, m_trade.getY() + m_addFriend.getHeight());
		getContentPane().add(m_addFriend);
		
		m_cancel = new Button("Cancel");
		m_cancel.setSize(100,25);
		m_cancel.setLocation(0, m_addFriend.getY() + m_cancel.getHeight());
		getContentPane().add(m_cancel);
		setBackground(new Color(0,0,0,150));
		setSize(100, 125 + m_name.getTextHeight());
		getTitleBar().setVisible(false);
		setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		
		m_battle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO: Battle request
				//GameClient.getInstance().getPacketGenerator().write("" + m_name.getText());
			}
		});
		m_trade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO: Trade request
				//GameClient.getInstance().getPacketGenerator().write("" + m_name.getText());
			}
		});
		m_addFriend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GameClient.getInstance().getPacketGenerator().write("Fa" + m_name.getText());
			}
		});
		m_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				destroy();				
			}
		});
	}

	/**
	 * Destroys the popup
	 */
	public void destroy(){
		GameClient.getInstance().getDisplay().remove(this);
	}
}