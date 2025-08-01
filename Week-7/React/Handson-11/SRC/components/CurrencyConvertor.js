import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: "",
      currency: "",
    };
  }

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { amount, currency } = this.state;
    // Only convert for "Euro"
    if (currency.toLowerCase() === "euro") {
      const rupees = parseFloat(amount);
      if (!isNaN(rupees)) {
        const euroAmount = rupees / 80;
        alert(`Converting to  Euro Amount is ${euroAmount}`);
      } else {
        alert("Please enter a numeric amount");
      }
    } else {
      alert("Please type 'Euro' as the currency");
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            Amount: <input name="amount" value={this.state.amount} onChange={this.handleChange} />
          </div>
          <div>
            Currency: <input name="currency" value={this.state.currency} onChange={this.handleChange} />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
