import "./App.css";
import { useState } from "react";

function App() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");

  let handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let res = await fetch("http://localhost:8080/addusers", {
        method: "POST",
        mode:'cors',
        headers: {

          'Accept': 'application/json',

          'Content-Type': 'application/json'

      },
        body: JSON.stringify({
          firstName: firstName,
          lastName: lastName,
          phoneNumber: phoneNumber,
          email: email
        })
      });
      console.log(res.body);
      //let resJson = await res.json();
      if (res.status === 200) {
        setFirstName("");
        setLastName("");
        setPhoneNumber("");
        setEmail("");
        setMessage("User created successfully");
      } else {
        setMessage("Some error occured");
      }
    } catch (err) {
      console.log(err);
    }
  };

  const getUsers = () => {
    fetch("http://localhost:8080/users")
      .then((response) => response.json())
      .then((json) => {console.log(json);});
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={firstName}
          placeholder="First name"
          onChange={(e) => setFirstName(e.target.value)}
        />
        <input
          type="text"
          value={lastName}
          placeholder="Last name"
          onChange={(e) => setLastName(e.target.value)}
        />
        <input
          type="text"
          value={phoneNumber}
          placeholder="Number"
          onChange={(e) => setPhoneNumber(e.target.value)}
        />
        <input
          type="text"
          value={email}
          placeholder="Email"
          onChange={(e) => setEmail(e.target.value)}
        />

        <button type="submit">Create</button>

        <div className="message">{message ? <p>{message}</p> : null}</div>
        <div><button type="button" onClick={getUsers}>Load users</button></div>
      </form>
    </div>
  );
}

export default App;