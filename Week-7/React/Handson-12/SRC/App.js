import React from "react";
import { Greeting } from "./components/Greeting";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    const { isLoggedIn } = this.state;
    let button;

    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogout} />;
    } else {
      button = <LoginButton onClick={this.handleLogin} />;
    }

    return (
      <div style={{margin: "5%"}}>
        <Greeting isLoggedIn={isLoggedIn} />
        {button}
      </div>
    );
  }
}

export default App;

