import { NavLink, Link } from "react-router-dom";
import React, { Component } from "react";
import logoo from "./images/logoo.jpeg";

export default class Navbar extends Component {
  state = {
    comp: true,
  };

  componentDidMount() {}

  handleClick = () => {
    localStorage.clear();
    this.setState({ comp: false });
  };

  render() {
    let buttons;

    if (localStorage.getItem("token")) {
      buttons = (
        <ul className="navbar-nav ml-auto">
          <li className="nav-item">
            <Link to={"/login"} onClick={this.handleClick} className="nav-link h5 text-success font-weight-bold"  >
              {" "}
              LogOut{" "}
            </Link>
          </li>
        </ul>
      );
    } else {
      buttons = (
        <ul className="nav navbar-right ml-auto">
          <li className="nav-item">
            <NavLink className="nav-link " exact to="/login">
            <p className="navheading h5 text-success font-weight-bold">login</p>
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink className="nav-link" exact to="/SignUp">
            <p className="navheading h5 text-success font-weight-bold">SignUp</p>
            </NavLink>
          </li>
        </ul>
      );
    }

    return (
      <div className="bodyy">
        <nav className="navbar navbar-expand-lg navbar-danger">
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <img class='logoimage' src={logoo} alt="logo"/> &nbsp;&nbsp;
            <p className="logo h2 font-weight-bold">Nutritonist</p> 
            <ul className="nav navbar-right ml-auto">
              <li className="nav-item">
                <NavLink className="nav-link" exact to="/">
                  <p className="navheading h5 text-success font-weight-bold">Home</p>
                </NavLink>
              </li>

              <li className="nav-item">
                <NavLink className="nav-link" exact to="/search">
                  <p className="navheading h5 text-success font-weight-bold">Search Food</p>
                </NavLink>
              </li>

              <li class="nav-item">
                <NavLink className="nav-link" exact to="/favfood">
               <p className="navheading h5 text-success font-weight-bold">Fav Food</p>
                </NavLink>
              </li>
              <li class="nav-item">
                <NavLink className="nav-link" exact to="/recommendedfood">
               <p className="navheading h5 text-success font-weight-bold">Recommended</p>
                </NavLink>
              </li>


              {buttons}
            </ul>
            
          </div>
        </nav>
      </div>
    );
  }
}
