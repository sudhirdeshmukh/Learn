import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import DesignPattern from './pages/DesignPattern';
import SystemDesign from './pages/SystemDesign';
import InterviewQA from './pages/InterviewQA';
import QuickRevision from './pages/QuickRevision';
import './index.css';

function App() {
  return (
    <Router basename="/Learn">
      <Layout>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/pattern/:patternName" element={<DesignPattern />} />
          <Route path="/system-design" element={<SystemDesign />} />
          <Route path="/interview-qa" element={<InterviewQA />} />
          <Route path="/quick-revision" element={<QuickRevision />} />
        </Routes>
      </Layout>
    </Router>
  );
}

export default App;
