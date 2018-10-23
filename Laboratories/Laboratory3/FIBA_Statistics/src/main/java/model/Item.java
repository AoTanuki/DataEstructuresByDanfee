package model;

import java.io.Serializable;

public class Item<P extends Number> implements Comparable<Item<P>>, Serializable {

	/**
	 * This attribute represents the value of this item
	 */
	private P value;

	/**
	 * This attribute has the reference to the player's txt that contains player's
	 * information who has this value in this item.
	 */
	private int txtIndex;

	/**
	 * @param value value of this item
	 * @param txtIndex index of the txt which has all information about the player
	 */
	public Item(P value, int txtIndex) {
		super();
		this.value = value;
		this.txtIndex = txtIndex;
	}

	/**
	 * this method returns the value of this item
	 * @return the value for this item
	 */
	public P getValue() {
		return value;
	}

	/**
	 * This method returns the index of txt that reference that player.
	 * @return index which indicate the number of this item's player.
	 */
	public int getTxtIndex() {
		return txtIndex;
	}

	/**
	 * this method allows change the value of this item.
	 * @param value new value for this item
	 */
	public void setValue(P value) {
		this.value = value;
	}

	/**
	 * this method allows to change the index of the txt that refers this player.
	 * @param txtIndex new index that refer a new player.
	 */
	public void setTxtIndex(int txtIndex) {
		this.txtIndex = txtIndex;
	}

	@Override
	public int compareTo(Item<P> o) {
		int result = 0;
		
		Number value1 = this.value;
		Number value2 = o.value;
		result = value1.floatValue()>value2.floatValue()?1:-1;
		return result;
	}
	
	

}
