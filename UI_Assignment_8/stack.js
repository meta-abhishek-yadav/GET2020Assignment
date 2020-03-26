stack = function() {
    this.stack = [];
    this.push = function(element) {
        this.stack.push(element);
    }
    this.pop = function() {
        this.stack.pop();
    }
}
abhishek = new stack();
abhishek.push(12);
abhishek.push(122);
abhishek.push(192);

abhishek.stack;
abhishek.pop();
abhishek.stack;