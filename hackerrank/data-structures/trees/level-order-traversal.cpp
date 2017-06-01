
/*
struct node
{
    int data;
    node* left;
    node* right;
}*/

void levelOrder(node * root) {
    
   struct queue {
       node* list_node;
       queue* next;
   };
    
    queue *start = new queue;
    queue *temp, *last = start;
    node *current;
    start->list_node = root;
    start->next = NULL;
    
   while (start != NULL) {
       
       current = start->list_node;
       start = start->next;
       
       cout << current->data << " ";
       if (current->left != NULL) {
           temp = new queue;
           temp->list_node = current->left;
           last->next = temp;
           last = temp;
           if (start == NULL) {
               start = last;
           }
       }
       if (current->right != NULL) {
           temp = new queue;
           temp->list_node = current->right;
           last->next = temp;
           last = temp;
           if (start == NULL) {
               start = last;
           }
       }
   }
}