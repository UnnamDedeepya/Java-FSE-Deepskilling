import React, { Component } from "react";

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 5 };
    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
  }

  // a) To increment the value
  handleIncrement(event) {
    this.setState(
      (prevState) => ({ count: prevState.count + 1 }),
      () => {
        // b) Say Hello after updating state
        this.sayHello(event);
      }
    );
  }

  handleDecrement() {
    this.setState((prevState) => ({ count: prevState.count - 1 }));
  }

  sayHello(event) {
    alert('Hello! Member1');
  }

  // 2. "Say Welcome" button
  sayWelcome = (msg) => {
    alert(msg);
  };

  // 3. Synthetic event demo
  handleClick = (e) => {
    alert("I was clicked");
    // Optionally, use event details: alert(e.type);
  };

  render() {
    return (
      <div>
        <div>{this.state.count}</div>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>
        <br />
        <button onClick={() => this.sayWelcome("welcome")}>Say welcome</button>
        <br />
        <button onClick={this.handleClick}>Click on me</button>
      </div>
    );
  }
}

export default Counter;
