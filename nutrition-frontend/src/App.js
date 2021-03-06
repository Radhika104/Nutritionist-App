import "./App.css";
import SignUp from "./Components/Auth/SignUp";
import login from "./Components/Auth/login";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Navbar from "./Components/Navbar/Navbar";
import Search from "./Components/Search/Search";
import Footer from "./Components/Footer/footer"

import Home from "./Components/Home/Home";
import NotFound from "./Components/NotFound/NotFound";
import favfood from "./Components/FavFood/favfood"
import LoginFirst from "./Components/NotFound/LoginFirst"
import recommendedfood from "./Components/RecommendedFood/recommendedfood";
function App() {


  return (
    <Router>
      <div className="App">
        <Navbar />
        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/search" component={Search} />
          <Route exact path="/login" component={login} />
          <Route exact path="/signup" component={SignUp} />
          <Route exact path="/favfood" component={localStorage.getItem("token") ? favfood : LoginFirst} />
          <Route exact path="/recommendedfood" component={localStorage.getItem("token") ? recommendedfood : LoginFirst} />
          <Route component={NotFound} />
        </Switch>
        <Footer/>
      </div>
    </Router>
  );
}

export default App;
