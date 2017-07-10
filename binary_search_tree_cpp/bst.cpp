#include "bst.hpp"
#include<iostream>
#include<fstream>

using namespace std;


void BST :: init(vector<int> values) 
{
	int value;
	for(int i=0;i<values.size();i++)
	{
		value = values.at(i);
		cout << "Inserting " << value << endl;
		insert(root, value);
	}
}

void BST :: insert(Node *& root, int value) 
{	
	if(root == NULL) 
		root = new Node(value) ;
	
	
	else if (value < root->value) 
		insert(root->left, value);

	else 
		insert(root->right, value);	
}

void print_aux(Node * root, int level) 
{
	if(root == NULL)
		return;

	print_aux(root->right, level+1) ;

	for(int i=0; i<3*level; i++)
		cout << " ";
	cout << root->value << endl;

	print_aux(root->left, level+1);
}

void BST :: print() 
{
	cout << endl;
	print_aux(root, 0);
}

void bst2dll_aux(Node *& curr, Node *& prev, Node *& head) 
{
	if(curr == NULL)
		return;
	 
	// go left
	bst2dll_aux(curr->left, prev, head);

	//process current
	if (prev == NULL) 
		head = curr;
	else  
	{
		prev->right = curr;
		curr->left = prev; 
	}

	Node * save_right = curr->right;

	curr->right = head;
	head->left = curr;
	// GO RIGHT
	prev = curr;
	bst2dll_aux(save_right, prev, head); 
}	

Node * BST :: bst2dll() 
{
	Node * head = NULL;
	Node * prev = NULL;
	bst2dll_aux(root, prev, head);

	return head;
}

void verfifyBST2DLL(Node * head, int total_elements) 
{	
	Node * temp = head;
	for(int i=0; i<total_elements; i++)
	{
		cout << temp->value << " ";
		temp = temp->left;
	}
	cout << endl;

	temp = head;
	for(int i=0; i<total_elements; i++)
	{
		cout << temp->value << " ";
		temp = temp->right;
	}
	cout << endl;
}

int main() 
{
	vector<int> values;
	int value;
	ifstream inFile;

	inFile.open("bst_input.txt");
	while (inFile >> value) 
		values.push_back(value);

	BST * bst = new BST();
	bst->init(values);
	bst->print();
	
	Node *head = bst->bst2dll();
	verfifyBST2DLL(head, values.size());
}