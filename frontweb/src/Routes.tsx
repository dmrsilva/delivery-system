import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Navbar from 'components/Navbar';
import Home from 'pages/Home';
import Menu from 'pages/Menu';
import Admin from 'pages/Admin';
import ProductDetails from 'pages/ProductDetails';

const Routes = () => (
  <BrowserRouter>
    <Navbar />
    <Switch>
      <Route path="/" exact>
        <Home />
      </Route>
      <Route path="/products" exact>
        <Menu />
      </Route>
      <Route path="/products/:productId">
        <ProductDetails />
      </Route>
      <Redirect from="/admin" to="/admin/products" exact/>
      <Route path="/admin">
        <Admin />
      </Route>
    </Switch>
  </BrowserRouter>
);

export default Routes;
