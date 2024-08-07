class LRUCache {
    Node head=new Node(0,0);
    Node tail= new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    

    public LRUCache(int capacity) {
        this.capacity= capacity;
        head.next= tail;
        tail.prev= head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){   // if the key is present in the map
            Node data= map.get(key);
            // move data to the top
            // remove the node and then insert at top most position
            //remove
            remove(data);
            // insert
            insert(data);
            return data.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // if value is already present we move it to top
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        // if chache is already present delete tail side node  -> least recently used data
        if(capacity==map.size()){
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
        
    }
    
    void remove(Node node){
        map.remove(node.key);
        node.prev.next= node.next;
        node.next.prev= node.prev;
    }
    
    void insert(Node node){
        map.put(node.key, node);
        Node headNext= head.next;
        head.next= node;
        node.prev= head;
        headNext.prev= node;
        node.next= headNext;
    }
    static class Node{
        Node next, prev;
        int key, value;
        
        Node(int key, int value){
            this. key= key;
            this.value= value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */