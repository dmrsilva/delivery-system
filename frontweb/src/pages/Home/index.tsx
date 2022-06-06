import MainImage from 'assets/images/main-image.png';
import ButtonIcon from 'components/ButtonIcon';
import Navbar from 'components/Navbar';

import './styles.css';

const Home = () => {
  return (
    <>
      <Navbar />
      <div className="home-container">
        <div className="home-card">
          <div className="home-content-container">
            <div>
              <h1>O número de clientes aumentou?</h1>
              <p>
                Simplificamos o gerenciamento de pedidos do seu estabelecimento.
              </p>
            </div>
            <ButtonIcon />
          </div>
          <div className="home-image-container">
            <img src={MainImage} alt="Entragador de motocicleta" />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
