import { useParams } from 'react-router-dom';
import ReactMarkdown from 'react-markdown';
import { patternData } from '../data/patterns';

export default function DesignPattern() {
  const { patternName } = useParams();
  const pattern = patternData[patternName];

  if (!pattern) return <div>Pattern not found</div>;

  return (
    <div className="bg-white rounded-lg shadow-md p-8">
      <h1 className="text-3xl font-bold text-gray-900 mb-4">{pattern.title}</h1>
      <div className="prose max-w-none">
        <ReactMarkdown>{pattern.content}</ReactMarkdown>
      </div>
    </div>
  );
}
