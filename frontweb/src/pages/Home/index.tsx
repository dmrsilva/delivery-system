import MainImage from 'assets/images/main-image.png';
import ButtonIcon from 'components/ButtonIcon';
import { Link } from 'react-router-dom';

import './styles.css';

const Home = () => {
  return (
    <div className="home-container">
      <div className="base-card home-card">
        <div className="home-content-container">
          <div>
            <h1>O número de clientes aumentou?</h1>
            <p>
              Simplificamos o gerenciamento de pedidos do seu estabelecimento.
            </p>
          </div>
          <div>
            <Link to="/admin/orders">
              <ButtonIcon text="Ir para página de pedidos"/>
            </Link>
          </div>
        </div>
        <div className="home-image-container">
          <img src={MainImage} alt="Entragador de motocicleta" />
        </div>
      </div>
    </div>
  );
};

export default Home;
