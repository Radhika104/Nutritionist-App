import React, { Component } from "react";
import "./css/home.css";
import line from "./images/line.webp";
import r1 from "./images/r11.jpg";
import r2 from "./images/r2.jpg";
import r3 from "./images/r3.png";
import apple from "./images/apple.webp";
import ab from "./images/ab.jpg";
import homeimage from "./images/nutritionist1.jpg";
import bannerimg from "./images/homeimagee.jpeg";


export default class Home extends Component {


  render() {
    return <div className="home-body">
      <div className="container-fluid">
        <img className="image-fluid" src={bannerimg} alt="vegetables" />
        <div className="jumbotron p-4 text-success">
          <h1>Welcome, Let's Get Stared With Todays Diet</h1>
        </div>



        <div className="section p-3 mb-3">
        <div className="row">
          <div className="col-md-3">
              <img className="rounded" src={apple} alt="" />
          </div>
          <div className="col-md-3 text-center p-2">
            <h2 className="font-weight-bold text-danger">Apple</h2>
            <br/>
            <h4 className="text-success">Energy 54 KCAL</h4>
            <br/>
            <h5 className="font-weight-bold">Sugar, Calcium, Iron, Potassium, Vitamin A, Vitamin C, Carbohydrate, Fiber, etc.</h5>
          </div>
          <div className="col-md-3">
              <img className="rounded" src={ab} alt="" />
          </div>
          <div className="col-md-3 text-center">
            <h2 className="font-weight-bold text-danger">Apple-Banana juice</h2>
            <br/>
            <h4 className="text-success">Energy 51 KCAL</h4>
            <br/>
            <h5 className="font-weight-bold">Sugar, Vitamin E, Folate, Chlorine, Carbohydrate, Calcium ,etc.</h5>
          </div>
        </div>
        </div>

      </div>

    </div>;
  }
}
