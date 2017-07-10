#ifndef BST_HPP
#define BST_HPP

#include<vector>

class Node {
	public:
	int value;
	Node * left;
	Node * right;

	Node(int p_value) : value(p_value) {}
};


class BST {
	Node * root;
public:
	
	void init(std::vector<int>) ;
	void insert(Node *&, int);
	void print();
	Node * bst2dll();
};


#endif