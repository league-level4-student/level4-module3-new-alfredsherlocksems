package _06_How_Many_Are_Smaller_Than_Me;

import _03_Intro_to_Binary_Trees.Node;
import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

	/*
	 * Given an AVLTree filled with the random numbers from 1 to 20, and a single
	 * number within the AVL Tree, figure out how many numbers in the AVLTree are
	 * smaller than the provided number and return the result.
	 * 
	 * You may want to create a helper method to search through the AVLTree and
	 * count iteratively or recursively.
	 */

	public int howManyAreSmallerThanMe(AVLTree<Integer> tree, int me) {
		AVLNode<Integer> root = tree.getRoot();

		return findTotal(root, me);

	}

	static int doubleIt(int me, Node<Integer> current) {
		if (current == null) {
			return 0;
		}
		if (current.getValue() < me) {
			return 1 + doubleIt(me, current.getLeft()) + doubleIt(me, current.getRight());
		} else {
			return doubleIt(me, current.getLeft()) + doubleIt(me, current.getRight());

		}
	}

	public int findTotal(AVLNode<Integer> current, int me) {

		if (current == null) {
			return 0;
		} else if (current.getValue() >= me) {
			return findTotal(current.getLeft(), me);
		} else {

			return 1 + findTotal(current.getLeft(), me) + findTotal(current.getRight(), me);
		}
	}
}