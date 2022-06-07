import AuthImage from 'assets/images/main-image.png';
import { Route, Switch } from 'react-router-dom';

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="auth-banner-container">
        <h1>Gerencie seus pedidos no Delivery System</h1>
        <p>A nossa solução é sinônimo de safistação para os seus clientes.</p>
        <img src={AuthImage} alt="Entragador de motocicleta" />
      </div>
      <div className="auth-form-container">
        <Switch>
          <Route path="/admin/auth/login">
            <h1>Card de Login</h1>
          </Route>
          <Route path="/admin/auth/signup">
            <h1>Card de Signup</h1>
          </Route>
          <Route path="/admin/auth/recover">
            <h1>Card de Recover</h1>
          </Route>
        </Switch>
      </div>
    </div>
  );
};

export default Auth;
