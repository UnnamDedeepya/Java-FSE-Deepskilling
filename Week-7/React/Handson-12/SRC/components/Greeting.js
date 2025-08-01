function GuestGreeting() {
  return (
    <div>
      <h1>Please sign up.</h1>
    </div>
  );
}

function UserGreeting() {
  return (
    <div>
      <h1>Welcome back!</h1>
      <FlightDetails />
      <BookTicket />
    </div>
  );
}

// Receives isLoggedIn prop and renders the right greeting
function Greeting(props) {
  if (props.isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

// Displays dummy flight details
function FlightDetails() {
  return (
    <div>
      <h2>Flight details:</h2>
      <ul>
        <li>Flight: AI-292</li>
        <li>From: Delhi</li>
        <li>To: Mumbai</li>
        <li>Time: 10:00 AM</li>
      </ul>
    </div>
  );
}

// Dummy ticket booking button
function BookTicket() {
  return <button>Book Ticket</button>;
}

export { Greeting };
