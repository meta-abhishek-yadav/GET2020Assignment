queue = function() {
    this.queue = [];
    this.enqueue = function(element) {
        this.queue.push(element);
    }
    this.dequeue = function() {
        this.queue.shift();
    }
}
abhishek = new queue();
abhishek.enqueue(12);
abhishek.enqueue(122);
abhishek.enqueue(192);

abhishek.queue;
abhishek.dequeue();
abhishek.queue;